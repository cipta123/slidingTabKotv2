package com.example.slidingtabkot

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment


class PageFragment : Fragment() {
    private var mPage = 0
    private var mUrl: String? = null
    lateinit var awebview: WebView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPage = requireArguments().getInt(ARG_PAGE)
        mUrl = requireArguments().getString(ARG_URL)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_page, container, false)

//        ProgressBar progressBar = view.findViewById(R.id.progressbar);
         awebview = rootView.findViewById(R.id.mWebview)
        awebview.webChromeClient = WebChromeClient()
        awebview.webViewClient = WebViewClient()
        awebview .settings.javaScriptEnabled = true


        awebview.webChromeClient = object : WebChromeClient() {
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)
                if (view == null) {
                    return
                }

                awebview.visibility = View.GONE
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

                // Add the custom view to the layout
                val decorView = requireActivity().window.decorView as FrameLayout
                decorView.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
                awebview.visibility = View.VISIBLE
                // Remove the custom view from the layout
                val decorView = requireActivity().window.decorView as FrameLayout
                decorView.removeViewAt(decorView.childCount - 1)
            }
        }
//        webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(
//                view: WebView,
//                request: WebResourceRequest
//            ): Boolean {
//                view.loadUrl(request.url.toString())
//                return true
//            }
//        }

        awebview.loadUrl(mUrl!!)
        return rootView
    }

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
        const val ARG_URL = "ARG_URL"
        fun newInstance(page: Int, url: String?): PageFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            args.putString(ARG_URL, url)
            val fragment = PageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}