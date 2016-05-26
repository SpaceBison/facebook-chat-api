import org.junit.Test;
import org.spacebison.facebookchatapi.api.Credentials;
import org.spacebison.facebookchatapi.api.FacebookChat;

import java.io.IOException;


/**
 * Created by cmb on 22.05.16.
 */
public class MainTest {
    FacebookChat mFacebookChat = new FacebookChat(new Credentials("temporalbison@gmail.com", "dupa cycki"));

    @Test
    public void test() throws IOException {
        mFacebookChat.login();
    }
}
