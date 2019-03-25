package com.lxisoft.client.xapi_launch_karma_app.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.lxisoft.client.xapi_launch_karma_app.ClientConfiguration;

@FeignClient(name="${XapiLaunchKarmaApp.name:XapiLaunchKarmaApp}", url="${XapiLaunchKarmaApp.url:localhost:8088/}", configuration = ClientConfiguration.class)
public interface UserResourceApiClient extends UserResourceApi {
}