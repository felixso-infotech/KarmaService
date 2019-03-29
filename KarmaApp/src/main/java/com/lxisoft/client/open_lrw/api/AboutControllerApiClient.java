package com.lxisoft.client.open_lrw.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.lxisoft.client.open_lrw.ClientConfiguration;

@FeignClient(name="${OpenLRW.name:OpenLRW}", url="${OpenLRW.url:localhost:9966/}", configuration = ClientConfiguration.class)
public interface AboutControllerApiClient extends AboutControllerApi {
}