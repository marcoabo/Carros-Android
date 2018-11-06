package br.com.livroandroid.carros.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.dialog.AboutDialog;
import livroandroid.lib.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteLivroFragment extends BaseFragment {

    private static final String URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm";
    private WebView webView;
    private ProgressBar progress;
    protected SwipeRefreshLayout swipeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_site_livro, container, false);
        webView = view.findViewById(R.id.webview);
        progress = view.findViewById(R.id.progress);
        setWebViewClient(webView);
        webView.loadUrl(URL_SOBRE);

        // Swipe to refresh
        swipeLayout = view.findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(OnRefreshListener());
        swipeLayout.setColorSchemeColors(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3);

        return view;
    }

    private SwipeRefreshLayout.OnRefreshListener OnRefreshListener() {

        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        };
    }

    private void setWebViewClient(WebView webView) {

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView webView, String url, Bitmap favicon){

                super.onPageStarted(webView, url, favicon);
                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView webView, String url){
                progress.setVisibility(View.INVISIBLE);
                swipeLayout.setRefreshing(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){

                Log.d("livroandroid", "webview url: " + url);

                if (url != null && url.endsWith("sobre.htm")){
                    AboutDialog.showAbout(getFragmentManager());
                    return true;
                }

                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}
