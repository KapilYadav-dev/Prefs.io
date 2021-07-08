# Prefs.io
A small and easy Shared Prefs library with more options : )

# Implementation
<p>Add jitpack to your maven sources</p>
<div class="highlight highlight-source-groovy"><pre>allprojects {
    repositories {
        <span class="pl-k">..</span>.
        maven { url <span class="pl-s"><span class="pl-pds">"</span>https://jitpack.io<span class="pl-pds">"</span></span> }
    }
}</pre></div>
<p>Add Censory as a dependency to your <code>build.gradle</code></p>
<div class="highlight highlight-source-groovy"><pre>dependencies {
    implementation <span class="pl-s"><span class="pl-pds">'</span>com.github.KapilYadav-dev:Prefs.io:CURRENT_RELEASE<span class="pl-pds">'</span></span>
}</pre></div>


# Usage
1) Initialization ( in application class )
2) Use it....

# Initialization

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Prefs class
        SharedPrefs.init(this);
    }



# Use it
After initialization, you can use simple one-line methods to save values to the shared preferences anywhere in your app, such as:

<ul>
<li><code>SharedPrefs.setString(key, string)</code></li>
<li><code>SharedPrefs.getString(key, defaultString")</code></li>
<li><code>SharedPrefs.setInteger(key, int)</code></li>
<li><code>SharedPrefs.getInteger(key, defaultInt)</code></li>
<li><code>SharedPrefs.setboolean(key, boolean)</code></li>
<li><code>SharedPrefs.getboolean(key, defaultBoolean)</code></li>
</ul>

# Encrypted Strings
<ul>
<li><code>SharedPrefs.setString(key, string, encryptionKey)</code></li>
<li><code>SharedPrefs.getString(key, defaultString, encryptionKey, encryptedText)</code></li>
</ul>

