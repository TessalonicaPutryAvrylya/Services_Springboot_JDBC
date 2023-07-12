package com.service.db2.DB2_Service.rest;

import com.service.db2.DB2_Service.model.Mahasiswa;
import com.service.db2.DB2_Service.service.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/mahasiswa")
public class MahasiswaRest {
    @Autowired
    private MahasiswaService mahasiswaService;
    @GetMapping(value = "/finds")
    public List<Mahasiswa> finds(){
        return mahasiswaService.findAll();
    }
    @PostMapping(value = "/save")
    public int save(@RequestBody String data){
        String[] arrData=data.split(";");
        Mahasiswa m=new Mahasiswa();
        m.setNim(arrData[0]);
        m.setNama(arrData[1]);
        return mahasiswaService.save(m);
    }
    @PostMapping(value = "/update")
    public int update(@RequestBody String data){
        String[] arrData=data.split(";");
        Mahasiswa m=new Mahasiswa();
        m.setId(Long.valueOf(arrData[0]));
        m.setNim(arrData[1]);
        m.setNama(arrData[2]);
        return mahasiswaService.update(m);
    }
    @PostMapping(value = "/delete")
    public int delete(@RequestBody String data){
        return mahasiswaService.deleteById(Long.valueOf(data));
    }
}
