package kim.bifrost.coldrain.wanandroid.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import kim.bifrost.coldrain.wanandroid.base.BaseActivity
import kim.bifrost.coldrain.wanandroid.databinding.ActivityWebPageBinding

class WebPageActivity : BaseActivity<ActivityWebPageBinding>() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.webPageToolbar.toolbar.apply {
            setSupportActionBar(this)
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.title = intent.getStringExtra("title")
            }
        }
        binding.wv.settings.javaScriptEnabled = true
        binding.wv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String
            ): Boolean {
                // 拦截恶意跳转
                if (url.startsWith("tbopen:") || url.startsWith("openapp")) return false
                return runCatching<Boolean> {
                    if (url.startsWith("http:") || url.startsWith("https:")) {
                        view?.loadUrl(url)
                    } else {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                        return@runCatching true
                    }
                    true
                }.getOrNull() ?: true
            }
        }
        binding.wv.loadUrl(intent.getStringExtra("url")!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    override fun getViewBinding(): ActivityWebPageBinding =
        ActivityWebPageBinding.inflate(layoutInflater)

    companion object {
        fun startActivity(context: Context, url: String, title: String) {
            context.startActivity(Intent(context, WebPageActivity::class.java).apply {
                putExtra("title", title)
                putExtra("url", url)
            })
        }
    }
}