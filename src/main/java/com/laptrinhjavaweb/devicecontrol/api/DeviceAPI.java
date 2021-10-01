package com.laptrinhjavaweb.devicecontrol.api;

import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;
import com.laptrinhjavaweb.devicecontrol.response.Response;
import com.laptrinhjavaweb.devicecontrol.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceAPI {

    @Autowired
    IDeviceService deviceService;

    @GetMapping("/device")
    public Response<DeviceDTO> getAll(@RequestParam(value = "category", required = false) Integer category){
        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setListResult(deviceService.findAll(category));
        return new Response<DeviceDTO>(deviceDTO);
    }

    @GetMapping("/device/{id}")
    public Response<DeviceDTO> getOne(@PathVariable("id") long id){
        DeviceDTO deviceDTO = deviceService.findOne(id);
        return new Response<DeviceDTO>(deviceDTO);
    }

    @PostMapping("/device")
    public Response<DeviceDTO> create( @RequestBody DeviceDTO deviceDTO){
        deviceDTO = deviceService.save(deviceDTO);
        return new Response<DeviceDTO>(deviceDTO);
    }

    @PutMapping("/device/{id}")
    public Response<DeviceDTO> update( @RequestBody DeviceDTO deviceDTO, @PathVariable("id") long id){
        deviceDTO.setId(id);
        deviceDTO = deviceService.save(deviceDTO);
        return new Response<DeviceDTO>(deviceDTO);
    }

    @PutMapping("/device/{code}/{status}")
    public Response<DeviceDTO> updateStatus(@PathVariable("code") String code, @PathVariable("status") long status){
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO = deviceService.updateStatus(code,status);
        return new Response<DeviceDTO>(deviceDTO);
    }

    @PostMapping("/device/{code}")
    public Response<DeviceDTO> updateHumAndTem(@RequestBody StatusDTO statusDTO, @PathVariable("code") String code){
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO = deviceService.updateStatusHumAndTem(code, statusDTO);
        return new Response<DeviceDTO>(deviceDTO);
    }

    @DeleteMapping("/device")
    public Response<DeviceDTO> delete( @RequestBody long[] ids){
        deviceService.delete(ids);
        return new Response<DeviceDTO>();
    }
}
