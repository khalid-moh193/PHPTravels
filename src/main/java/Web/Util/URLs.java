package Web.Util;

public enum URLs {


    PHP_TRAVELS("https://www.phptravels.net/register"),
    TEMP_EMAIL("https://temp-mail.org/en/");
    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
