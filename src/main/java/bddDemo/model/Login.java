/**
 *
 */
package bddDemo.model;

/**
 * @author Barnaby Golden
 *
 */
public final class Login {

    /**
     * Username.
     */
    private String username;
    /**
     * Password.
     */
    private String pwd;
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }
    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }
    /**
     * @param pwd the pwd to set
     */
    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
}
