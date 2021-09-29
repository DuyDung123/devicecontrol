package com.laptrinhjavaweb.devicecontrol.config;

import com.laptrinhjavaweb.devicecontrol.converter.CategoryConverter;
import com.laptrinhjavaweb.devicecontrol.converter.DeviceConverter;
import com.laptrinhjavaweb.devicecontrol.converter.StatusConverter;
import com.laptrinhjavaweb.devicecontrol.converter.UserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

    @Bean
    public CategoryConverter categoryConverterBean() throws Exception{
        return new CategoryConverter();
    }

    @Bean
    public UserConverter userConverterBean() throws Exception{
        return  new UserConverter();
    }

    @Bean
    public DeviceConverter deviceConverterBean() throws Exception{
        return  new DeviceConverter();
    }
    @Bean
    public StatusConverter statusConverterBean() throws Exception{
        return new StatusConverter();
    }

}
