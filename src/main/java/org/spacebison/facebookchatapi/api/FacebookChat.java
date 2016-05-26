package org.spacebison.facebookchatapi.api;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

import org.spacebison.util.RegexUtils;

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
    private final WebClient webClient = new WebClient();
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder().cookieJar(new SimpleCookieJar()).addInterceptor(new UserAgentInterceptor()).build();
    private final FacebookApi mFacebookApi = new Retrofit.Builder().client(mOkHttpClient).baseUrl(FacebookApi.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build().create(FacebookApi.class);
    private final EdgeChatFacebookApi mEdgeChatFacebookApi = new Retrofit.Builder().client(mOkHttpClient).baseUrl(EdgeChatFacebookApi.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build().create(EdgeChatFacebookApi.class);
    private final Credentials mCredentials;

    public FacebookChat(Credentials credentials) {
        mCredentials = credentials;
    }

    public void login() throws java.io.IOException {
        HtmlPage loginPage = webClient.getPage("https://www.facebook.com");
        HtmlForm loginForm = (HtmlForm) loginPage.getElementById("login_form");

        final HtmlSubmitInput submitButton = (HtmlSubmitInput) loginForm.getInputsByValue("Log In").get(0);

        HtmlInput emailInput = loginForm.getInputByName("email");
        emailInput.setValueAttribute(mCredentials.getEmail());

        HtmlInput passwordInput = loginForm.getInputByName("pass");
        passwordInput.setValueAttribute(mCredentials.getPassword());

        HtmlPage loggedIn = submitButton.click();
        WebResponse webResponse = loggedIn.getWebResponse();

        System.out.println("#### Request ####");
        WebRequest webRequest = loggedIn.getWebResponse().getWebRequest();

        System.out.println(webRequest.getRequestBody());

        for (NameValuePair nvp : webRequest.getRequestParameters()) {
            System.out.println(nvp.toString());
        }

        System.out.println("Loaded " + loggedIn.getUrl());
        System.out.println("Title: " + loggedIn.getTitleText());
        System.out.println("Code: " + webResponse.getStatusCode());
        System.out.println("Message: " + webResponse.getStatusMessage());
        System.out.println("headers:");
        for (NameValuePair nvp : webResponse.getResponseHeaders()) {
            System.out.println(nvp.toString());
        }
        System.out.println("\n####Body: ####\n" + webResponse.getContentAsString());

        Set<com.gargoylesoftware.htmlunit.util.Cookie> cookies = webClient.getCookies(new URL(FacebookApi.BASE_URL));

        ArrayList<Cookie> newCookies = new ArrayList<>(cookies.size());
        HttpUrl httpUrl = HttpUrl.parse(FacebookApi.BASE_URL);
        for (com.gargoylesoftware.htmlunit.util.Cookie c : cookies) {
            System.out.println(c.toString());
            newCookies.add(Cookie.parse(httpUrl, c.toString()));
        }
        mOkHttpClient.cookieJar().saveFromResponse(httpUrl, newCookies);

        //loginFormParams.put("email", email);
        //loginFormParams.put("pass", pass);

/*
        Response<String> reconnect = mFacebookApi.reconnect(6).execute();
        System.out.println("Reconnect: " + RetrofitUtils.toString(reconnect));

        Response<String> secondMainPage = mFacebookApi.mainPage().execute();

        String body = secondMainPage.body();

        System.out.println(body);

        Matcher matcher = MAIN_PAGE_LOGIN_FORM.matcher(body);
        matcher.find();
        String formString = matcher.group();

        System.out.println(formString.replace("><", "\n"));

        HashMap<String, String> formMap = new HashMap<>();

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse(new ByteArrayInputStream(formString.getBytes()));
            Element loginForm = document.getDocumentElement();
            NodeList childNodes = loginForm.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); ++i) {
                Node item = childNodes.item(i);
                NamedNodeMap attributes = item.getAttributes();
                Node typeItem = attributes.getNamedItem("type");
                String type = typeItem == null ? "" : typeItem.getNodeValue();
                Node nameItem = attributes.getNamedItem("name");
                String name = nameItem == null ? "" : nameItem.getNodeValue();
                Node valueItem = attributes.getNamedItem("value");
                String value = valueItem == null ? "" : valueItem.getNodeValue();

                System.out.println(type + " " + name + "=" + value);

                if ("hidden".equalsIgnoreCase(type)) {
                    formMap.put(name, value);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
*/

        /*
        String lsd = getLsd(body);
        String lgnrnd = getLgnrnd(body);
        String lgndim = DatatypeConverter.printBase64Binary("{\"w\":1440,\"h\":900,\"aw\":1440,\"ah\":834,\"c\":24}".getBytes("UTF-8"));

        System.out.println("LSD: " + lsd);
        System.out.println("LGNRND: " + lgnrnd);
        System.out.println("LGNDIM: " + lgndim);
        */

       // Call<String> loginCall = mFacebookApi.login(1, 110, mCredentials.getEmail(), mCredentials.getPassword(), 1, formData);
       // Response<String> login = loginCall.execute();
//        System.out.println("login URL: " + loginCall.request().url());
//        System.out.println("login headers: " + loginCall.request().headers().toMultimap().size());
//        System.out.println("login cookies: " + mOkHttpClient.cookieJar().loadForRequest(loginCall.request().url()));
//        System.out.println("login BODY " + RetrofitUtils.bodyToString(loginCall.request()));
       // System.out.println("\n#############\n");
      //  System.out.println("RESPONSE: " + RetrofitUtils.toString(login));

        /*
        Response<String> reconnect = mFacebookApi.reconnect(6).execute();
        System.out.println("Cookies: " + Cookie.parseAll(HttpUrl.parse(""), reconnect.headers()));
        */
    }

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
