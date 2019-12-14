# OkhttpUtils

# 配置框架

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  dependencies {
	        implementation 'com.github.android-work:OkhttpUtils:v1.0.0'
	}

封装okhttp框架
  OkhttpUtils.getInstance().setHandler(Handler); 在application中初始化一个全局的handler用户线程切换
  
  LogUtils.isLoge(true,false,false,false);log工具类参1 log.e、参2 log.w、 参3 log.d、参4 log.i
  
  OkhttpUtils.getInstance().getBuilder();获取okhttp的OkHttpClient.Builder，用户自定义一些请求时间或添加拦截器
  
  OkhttpUtils.getInstance().getRequestBuilder()；获取okhttp的Request.Builder，用户添加一些head
  
  get请求 OkhttpUtils.getInstance().getHttp(String url, Map<String, String> params, String tag, Class tClass, HttpRequestCallback callback)
 参1 请求地址、参2 上传参数集合、参3 取消请求的tag、参4 请求结果的字节码文件、参5 请求结果的回调（内置HttpRequestCallback，需要实现）#  put/post请求 multabNetwork(String url, String methed, String body, String tag, Map<String,String> paramsMap, Map<String, File> fileMap, Class tClass, HttpRequestCallback callback)
 参1 同上、参2 请求方式、参3 请求body、参4 同上参3、参5 同上参2、参6 上传多个图片、参7 同上参4、参8 同上参5
 
  cancelTag（tag); 取消网络请求
