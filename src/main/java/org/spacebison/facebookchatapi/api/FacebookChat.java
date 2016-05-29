package org.spacebison.facebookchatapi.api;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

import org.spacebison.facebookchatapi.generated.js2p.Batch;
import org.spacebison.util.RegexUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by cmb on 22.05.16.
 */
public class FacebookChat {
    private static final Pattern MAIN_PAGE_COOKIES = Pattern.compile("\\[\"_js_(.*?)\",\"(.*?)\".(.*?),\"(.*?)\",(true|false),(true|false),(true|false)\\]");
    private static final Pattern MAIN_PAGE_LSD = Pattern.compile("\\[\\\"LSD\\\",\\[\\],\\{\\\"token\\\":\\\"(.*?)\\}");
    private static final Pattern MAIN_PAGE_LGNRND = Pattern.compile("name=\"lgnrnd\" value=\"(.*?)\"");
    private static final Pattern MAIN_PAGE_LOGIN_FORM = Pattern.compile("<form id=\"login_form\".*?</form>");
    private final WebClient webClient = new WebClient(BrowserVersion.CHROME);
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .cookieJar(new SimpleCookieJar())
            .addInterceptor(new UserAgentInterceptor())
            .build();
    private final FacebookApi mFacebookApi = new Retrofit.Builder()
            .client(mOkHttpClient).baseUrl(FacebookApi.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(FacebookEntityConverterFactory.create())
            .build()
            .create(FacebookApi.class);
    private final EdgeChatFacebookApi mEdgeChatFacebookApi = new Retrofit.Builder()
            .client(mOkHttpClient)
            .baseUrl(EdgeChatFacebookApi.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(FacebookEntityConverterFactory.create())
            .build()
            .create(EdgeChatFacebookApi.class);
    private final Credentials mCredentials;

    public FacebookChat(Credentials credentials) {
        mCredentials = credentials;
    }

    public String login() throws java.io.IOException {
        HtmlPage loginPage = webClient.getPage("https://www.facebook.com");
        HtmlForm loginForm = (HtmlForm) loginPage.getElementById("login_form");

        // TODO: 29.05.16 handle index out of bounds
        final HtmlSubmitInput submitButton = (HtmlSubmitInput) loginForm.getInputsByValue("Log In").get(0);

        HtmlInput emailInput = loginForm.getInputByName("email");
        emailInput.setValueAttribute(mCredentials.getEmail());

        HtmlInput passwordInput = loginForm.getInputByName("pass");
        passwordInput.setValueAttribute(mCredentials.getPassword());

        HtmlPage loggedIn = submitButton.click();
       // WebResponse webResponse = loggedIn.getWebResponse();

        Set<com.gargoylesoftware.htmlunit.util.Cookie> cookies = webClient.getCookies(new URL(FacebookApi.BASE_URL));

        String userId = null;
        ArrayList<Cookie> newCookies = new ArrayList<>(cookies.size());
        HttpUrl httpUrl = HttpUrl.parse(FacebookApi.BASE_URL);

        for (com.gargoylesoftware.htmlunit.util.Cookie c : cookies) {
            System.out.println("Cookie: " + c.toString());
            newCookies.add(Cookie.parse(httpUrl, c.toString()));
            if ("c_user".equals(c.getName())) {
                userId = c.getValue();
                System.out.println("Logged in userId: " + userId);
            }
        }

        mOkHttpClient.cookieJar().saveFromResponse(httpUrl, newCookies);

        Call<String> reconnect = mFacebookApi.reconnect(6, userId, 1, "", 3, 0, "PHASED:DEFAULT", 0, "");

        Request request = reconnect.request();
        String method = request.method();
        HttpUrl url = request.url();
        System.out.println(method + ' ' + url);

        for (int i = 0; i < url.querySize(); ++i) {
            System.out.println("  " + url.queryParameterName(i) + " = " + url.queryParameterValue(i));
        }

        Response<String> execute = reconnect.execute();

        System.out.println(execute.headers().toString());

        return userId;
    }

    public void getFriendsList(String userId) throws IOException {
        Call<Batch> pullCall = mEdgeChatFacebookApi.pull(
                "p_" + userId,
                1,
                -2,
                "4fdb6d8",
                "3ttw",
                "y",
                "fresh",
                5,
                userId,
                userId,
                1,
                "FRC",
                "active",
                1,
                8,
                0);
        Request request = pullCall.request();
        String method = request.method();
        HttpUrl url = request.url();
        System.out.println(method + ' ' + url);

        for (int i = 0; i < url.querySize(); ++i) {
            System.out.println("  " + url.queryParameterName(i) + " = " + url.queryParameterValue(i));
        }

        Response<Batch> pull = pullCall.execute();

        System.out.println("FRIENDS");
        System.out.println(pull.code());
        System.out.println(pull.headers());
        System.out.println(pull.body());
    }
    /*

 c_user=100011911477064
 csm=2
datr=DWRJV3HpC9gyWHyNP-Nc8gZH
 fr=0PNsAqm5z2VhVDd4b.AWWie-Cu98htf6mZ2w35JtA2xoU.BXSWQg.D4.AAA.0.0.AWVP5AN2
 lu=ggVAL1UhIY6T6JpB5LOSX0cg
 p=-2
 pl=n
 presence=EDvF3EtimeF1464427555EuserFA21B11911477064A2EstateFDutF0Et2F_5b_5dElm2FnullEuct2F1464426953BEtrFnullEtwF2524536875EatF1464427555220CEchFDp_5f1B11911477064F0CC
 s=Aa55bMG_Qhv4V4Go.BXSWQh
 sb=IGRJV8k6_-Ce3vT4mEfEDxWh
 xs=196%3AcTqWewKVMaJw1g%3A2%3A1464427552%3A7592


  _js_datr=DGNJV6lATqlek0nMlTnLxkI0; expires=Mon, 28 May 2018 11:21:33 GMT; domain=facebook.com; path=/
  _js_reg_fb_gate=https%3A%2F%2Fweb.facebook.com%2F; domain=facebook.com; path=/
  _js_reg_fb_ref=https%3A%2F%2Fweb.facebook.com%2F; domain=facebook.com; path=/
  c_user=100011911477064; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/; secure
  csm=2; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/
  datr=DGNJV6lATqlek0nMlTnLxkI0; expires=Mon, 28 May 2018 11:21:34 GMT; domain=facebook.com; path=/; httponly
  fr=0zGr3Mw9BNxu24dKs.AWXfZ-pZ5gObasx_VG2UXykVZJQ.BXSWMe.18.AAA.0.0.AWWt3ofx; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/; httponly
  lu=gg3avh7e00P5fZdheItC6yyQ; expires=Mon, 28 May 2018 11:21:34 GMT; domain=facebook.com; path=/; secure; httponly
  pl=n; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/; secure; httponly
      s=Aa4DEBRjgybA2Ex8.BXSWMe; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/; secure; httponly
  sb=HmNJV2W2GtQSTib9v4fV7tM-; expires=Mon, 28 May 2018 11:21:34 GMT; domain=facebook.com; path=/; secure; httponly
  xs=85%3A88rtc_Cc_bp36g%3A2%3A1464427294%3A7592; expires=Fri, 26 Aug 2016 11:21:34 GMT; domain=facebook.com; path=/; secure; httponly
     */

    private void loadCookiesFromMainPage(String body) {
        List<String> cookiesFromMainPage = getCookiesFromMainPage(body);

        System.out.println("Extracted cookies: " + cookiesFromMainPage);

        List<Cookie> cookies = new ArrayList<>(cookiesFromMainPage.size());
        HttpUrl url = HttpUrl.parse("https://facebook.com");
        for (String cookieString : cookiesFromMainPage) {
            Cookie cookie = Cookie.parse(url, cookieString);
            System.out.println(cookie);
            cookies.add(cookie);
        }

        System.out.println("Save from response: " + cookies);
        mOkHttpClient.cookieJar().saveFromResponse(url, cookies);
    }

    private String getLgnrnd(String body) {
        Matcher lgnrndMatcher = MAIN_PAGE_LGNRND.matcher(body);
        lgnrndMatcher.find();
        return lgnrndMatcher.group(1);
    }

    private String getLsd(String body) {
        Matcher lsdMatcher = MAIN_PAGE_LSD.matcher(body);
        lsdMatcher.find();
        return lsdMatcher.group(1);
    }

    private List<String> getCookiesFromMainPage(String html) {
        Matcher matcher = MAIN_PAGE_COOKIES.matcher(html);
        List<String> cookies = new LinkedList<>();
        while (matcher.find()) {
            String[] groups = RegexUtils.getGroups(matcher);
            cookies.add(formatCookie(groups, "facebook"));
        }
        return cookies;
    }

    private String formatCookie(String[] arr, String url) {
        return arr[0] + "=" + arr[1] + "; Path=" + arr[3] + "; Domain=" + url + ".com";
    }

    private String formatCookie(String key, String value, String path, String url) {
        return key + "=" + value + "; Path=" + path + "; Domain=" + url;
    }
}
