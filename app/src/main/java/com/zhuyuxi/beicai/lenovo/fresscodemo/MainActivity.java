package com.zhuyuxi.beicai.lenovo.fresscodemo;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.my_image_view)
    private SimpleDraweeView draweeView;

    private static final   String img_url01="http://101.200.167.75:8080/phoenixshop/img/banner/5608f3b5Nc8d90151.jpg/test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
//        Uri uri = Uri.parse(img_url01);
//        draweeView.setImageURI(uri);



        requestImage();
    }
    //渐进式JPEG加载图片
    private  void requestImage(){
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(img_url01))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller =(PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }
}
