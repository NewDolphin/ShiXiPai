package com.shixipai.interactor;


import com.shixipai.ui.common.OnGetJobItemsCallback;

/**
 * Created by WGL on 2015/3/28.
 */
public class JobInteractorImpl implements JobInteractor {

//    private static final String LOG_TAG = JobInteractorImpl.class.getSimpleName();
//
//    @Override
//    public void getExploreItems(int per_page,
//                                int page,
//                                int day,
//                                int isRecommend,
//                                String sortType,
//                                final OnGetExploreItemsCallback onGetExploreItemsCallback) {
//        ApiClient.getExplore(per_page,page,day,isRecommend,sortType,new JsonHttpResponseHandler(){
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                super.onSuccess(statusCode, headers, response);
//                LogHelper.v(LOG_TAG, response.toString());
//                try{
//                    switch (response.getInt(ApiClient.RESP_ERROR_CODE_KEY)){
//                        case ApiClient.SUCCESS_CODE:
//                            Gson gson = new Gson();
//                            ExploreResponse erm =
//                                    gson.fromJson(response.getJSONObject(ApiClient.RESP_MSG_KEY).toString(),ExploreResponse.class);
//                            LogHelper.v(LOG_TAG, erm.toString());
//                            onGetExploreItemsCallback.onSuccess(erm);
//                            break;
//                        case ApiClient.ERROR_CODE:
//                            onGetExploreItemsCallback.onFailed(response.getString(ApiClient.RESP_ERROR_MSG_KEY));
//                            break;
//
//                    }
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    @Override
    public void getJobItems(int page, OnGetJobItemsCallback onGetExploreItemsCallback) {
//        ApiClient.getJobItems(page,new JsonHttpResponseHandler(){
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                super.onSuccess(statusCode, headers, response);
//            }
//        });
    }
}
