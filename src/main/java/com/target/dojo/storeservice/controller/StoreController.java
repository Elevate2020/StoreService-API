package com.target.dojo.storeservice.controller;

import com.target.dojo.storeservice.domain.Store;
import com.target.dojo.storeservice.repository.StoreRepository;
import com.target.dojo.storeservice.service.StoreService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Summary;
import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;
import java.util.List;


/**
 * Created by z063221 on 3/9/17.
 */

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreRepository storeRepository;

    static final Counter requests = Counter.build()
           // .name("requests_total").help("Total requests.").register();
                .name("requests_total").help("Total requests.").labelNames("pogType", "pogGroup").register();

    private static final Summary responseTimeInMs = Summary
            .build()
            .name("http_response_time_milliseconds")
            .labelNames("method", "handler", "status")
            .help("Request completed time in milliseconds")
            .register();

    private boolean toggle = false;
    @GetMapping("/{cityName}/{storeID}")
    @ResponseBody
    @Transactional(readOnly = true)
    public Store getHotelDetails(@PathVariable String cityName, @PathVariable Long storeID ) {

        long startTime  = System.currentTimeMillis();
        if(toggle) {
            requests.labels("A", "B").inc();

        } else{
            requests.labels("X", "B").inc();
        }

        toggle = !toggle;

        long completedTime = System.currentTimeMillis() - startTime;
        responseTimeInMs.labels("GET", "Something", "200").observe(
                completedTime);

        return this.storeService.getStore(cityName, storeID);


    }

    @GetMapping("/{cityName}")
    @ResponseBody
    @Transactional(readOnly = true)
    public List<Store> getHotelDetails(@PathVariable String cityName) {

        long startTime  = System.currentTimeMillis();
        if(toggle) {
            requests.labels("A", "B").inc();

        } else{
            requests.labels("X", "B").inc();
        }

        toggle = !toggle;

        long completedTime = System.currentTimeMillis() - startTime;
        responseTimeInMs.labels("GET", "Something", "200").observe(
                completedTime);

        return this.storeService.getStoreList(cityName);


    }


    @RequestMapping(path = "/prom_metrics", method = RequestMethod.GET)
    public void metrics(Writer responseWriter) throws IOException {
        TextFormat.write004(responseWriter, CollectorRegistry.defaultRegistry.metricFamilySamples());
        responseWriter.close();
    }

    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public String getHealth() {
        return "Healthy!!!";
    }

    @RequestMapping(path = "/ready", method = RequestMethod.GET)
    public Long getReadiness() {
        return storeRepository.count();
    }


}
