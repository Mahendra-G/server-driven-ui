package com.example.serverdrivenuiapplication.ui.dynamicScreen;

import android.util.Log;

import com.example.serverdrivenuiapplication.model.DataResponse;
import com.example.serverdrivenuiapplication.model.ResultResponse;
import com.example.serverdrivenuiapplication.network.APIClient;
import com.example.serverdrivenuiapplication.network.APIService;
import com.example.serverdrivenuiapplication.network.APICallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DynamicUiRepository {

    ResultResponse resultResponse;

    public void displayScreen(int selectedId, final APICallBack<DataResponse> callBack) {
        APIService apiService = APIClient.getRetrofitClient().create(APIService.class);
        Call<DataResponse> call = apiService.getType(selectedId);
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                Log.e("Status","code...."+response.code());
                DataResponse dataResponse = response.body();
                resultResponse=  dataResponse.getResponses();
                callBack.onSuccess(dataResponse);
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                callBack.onFailure();
            }
        });
    }
}
