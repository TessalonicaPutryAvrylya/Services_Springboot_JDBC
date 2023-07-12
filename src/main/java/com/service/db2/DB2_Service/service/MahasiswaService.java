package com.service.db2.DB2_Service.service;

import com.service.db2.DB2_Service.model.Mahasiswa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int save(Mahasiswa mahasiswa){
        return jdbcTemplate.update("INSERT INTO tb_mahasiswa (nim,nama) VALUES(?,?)",
                new Object[]{mahasiswa.getNim(),mahasiswa.getNama()});}
    public int update(Mahasiswa mahasiswa){
        return jdbcTemplate.update("UPDATE tb_mahasiswa SET nim=?,nama=? WHERE id=?",
                new Object[]{mahasiswa.getNim(),mahasiswa.getNama(),mahasiswa.getId()});}
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM tb_mahasiswa WHERE id=?", id);
    }
    public List<Mahasiswa> findAll(){
        return jdbcTemplate.query("SELECT * FROM tb_mahasiswa",BeanPropertyRowMapper.newInstance(Mahasiswa.class));
    
    }
    
}
