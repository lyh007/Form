package com.form;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class Version {
    public final static String VERSION_MAJOR = "version.major";

    public final static String VERSION_MINOR = "version.minor";

    public final static String VERSION_REVISION = "version.revision";

    public final static String VERSION_NAME = "version.name";

    public final static String VERSION_SVNTAG = "version.svntag";

    public final static String VERSION_SVNTAG_PREFIX = "version.svntag.prefix";

    public final static String BUILD_NUMBER = "build.number";

    public final static String BUILD_ID = "build.id";

    public final static String BUILD_DATE = "build.day";

    public final static String BUILD_JVM_VERSION = "java.vm.version";

    public final static String BUILD_JVM_VENDOR = "java.vendor";

    public final static String BUILD_OS = "os.name";

    public final static String BUILD_OS_ARCH = "os.arch";

    public final static String BUILD_OS_VERSION = "os.version";
    public final static String SYSTEM_TITLE = "system.title";
    public final static String SYSTEM_ADMIN_MAIL = "system.admin.mail";

    public final static String SYSTEM_COMPANY = "system.company";

    public final static String SYSTEM_COPYRIGHT = "system.copyright";
    /**
     * The single instance.
     */
    private static Version instance = null;

    /**
     * The version properties.
     */
    private Properties props;

    /**
     * Do not allow direct public construction.
     */
    private Version() {
        props = loadProperties();
    }

    /**
     * Get the single <tt>Version</tt> instance.
     *
     * @return The single <tt>Version</tt> instance.
     */
    public static Version getInstance() {
        if (instance == null) {
            instance = new Version();
        }
        return instance;
    }

    /**
     * Returns an unmodifiable map of version properties.
     *
     * @return An unmodifiable map of version properties.
     */
    public Map getProperties() {
        return Collections.unmodifiableMap(props);
    }

    /**
     * Returns the value for the given property name.
     *
     * @param name - The name of the property.
     * @return The property value or null if the property is not set.
     */
    public String getProperty(final String name) {
        return props.getProperty(name);
    }

    /**
     * @param key - The name of the property.
     * @return The property value or null if the property is not set.
     */
    public void setProperty(String key, String newValue) {
        props.setProperty(key, newValue);
    }

    /**
     * Returns the major number of the version.
     *
     * @return The major number of the version.
     */
    public int getMajor() {
        return getIntProperty(VERSION_MAJOR);
    }

    /**
     * Returns the minor number of the version.
     *
     * @return The minor number of the version.
     */
    public int getMinor() {
        return getIntProperty(VERSION_MINOR);
    }

    /**
     * Returns the revision number of the version.
     *
     * @return The revision number of the version.
     */
    public int getRevision() {
        return getIntProperty(VERSION_REVISION);
    }

    /**
     * Returns the SVN tag of the version.
     *
     * @return The SVN tag of the version.
     */
    public String getSvnTag() {
        String svnTag = props.getProperty(VERSION_SVNTAG_PREFIX);
        String value = "";
        try {
            value = new String(svnTag.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value + props.getProperty(VERSION_SVNTAG);
    }

    /**
     * Returns the name number of the version.
     *
     * @return The name of the version.
     */
    public String getName() {
        return props.getProperty(VERSION_NAME);
    }

    /**
     * Returns the build identifier for this version.
     *
     * @return The build identifier for this version.
     */
    public String getBuildID() {
        return props.getProperty(BUILD_ID);
    }

    /**
     * Returns the build number for this version.
     *
     * @return The build number for this version.
     */
    public String getBuildNumber() {
        return props.getProperty(BUILD_NUMBER);
    }

    /**
     * Returns the build date for this version.
     *
     * @return The build date for this version.
     */
    public String getBuildDate() {
        return props.getProperty(BUILD_DATE);
    }

    /**
     * Returns the BUILD_JVM_VERSION (BUILD_JVM_VENDOR) which should look like: 1.4.2_05-b04 (Sun Microsystems Inc.)
     *
     * @return
     */
    public String getBuildJVM() {
        String vm = props.getProperty(BUILD_JVM_VERSION);
        String vendor = props.getProperty(BUILD_JVM_VENDOR);
        return vm + '(' + vendor + ')';
    }

    /**
     * Returns the BUILD_OS (BUILD_OS_ARCH,BUILD_OS_VERSION) which should look like: Windows XP (x86,5.1) Linux
     * (i386,2.4.21-4.ELsmp)
     *
     * @return
     */
    public String getBuildOS() {
        String os = props.getProperty(BUILD_OS);
        String arch = props.getProperty(BUILD_OS_ARCH);
        String version = props.getProperty(BUILD_OS_VERSION);
        return os + '(' + arch + ',' + version + ')';
    }

    /**
     * Returns the full version number, e.g. 5.0.0.GA
     *
     * @return The full version number as string
     */
    public String getVersionNumber() {
        StringBuffer buff = new StringBuffer();
        buff.append(getMajor()).append(".");
        buff.append(getMinor()).append(".");
        buff.append(getRevision());
        return buff.toString();
    }

    /**
     * get System Title
     *
     * @return
     */
    public String getSystemTitle() {
        String systemTitle = props.getProperty(SYSTEM_TITLE);
        String value = "";
        try {
            value = new String(systemTitle.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value;

    }

    /**
     * get system administrator email
     *
     * @return
     */
    public String getSystemMail() {
        return props.getProperty(SYSTEM_ADMIN_MAIL);
    }

    /**
     * get Company Name
     *
     * @return
     */
    public String getCompany() {
        String company = props.getProperty(SYSTEM_COMPANY);
        String value = "";
        try {
            value = new String(company.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * get copy right
     *
     * @return
     */
    public String getCopyright() {
        String cr = props.getProperty(SYSTEM_COPYRIGHT);
        String value = "";
        try {
            value = new String(cr.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Returns the version information as a string.
     *
     * @return Basic information as a string.
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("product version：");
        buff.append(getVersionNumber());
        buff.append(" (Build: SVNTag=");
        buff.append(getSvnTag());
        buff.append(")\n");
        buff.append("public date：");
        buff.append(getBuildDate());
        buff.append("\n");
        buff.append("Java：");
        buff.append(System.getProperty("java.runtime.version") + ";" + System.getProperty("java.vm.name") + ";"
                + System.getProperty("java.vm.vendor"));
        buff.append("\n");
        buff.append("Operation System：");
        buff.append(System.getProperty("os.arch") + ";");
        buff.append(System.getProperty("os.name") + " " + System.getProperty("os.version"));
        buff.append("\n");
        buff.append("File Encodeing：");
        buff.append(System.getProperty("file.encoding"));
        return buff.toString();
    }

    /**
     * Returns a property value as an int.
     *
     * @param name - The name of the property.
     * @return The property value, or -1 if there was a problem converting it to an int.
     */
    private int getIntProperty(final String name) {
        try {
            return Integer.valueOf(props.getProperty(name)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Load the version properties from a resource.
     */
    public Properties loadProperties() {
        props = new Properties();
        try {
            InputStream in = Version.class.getResourceAsStream("/version.properties");
            props.load(in);
            in.close();
        } catch (IOException e) {
            throw new Error("Missing version.properties");
        }
        return props;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties());
    }
}