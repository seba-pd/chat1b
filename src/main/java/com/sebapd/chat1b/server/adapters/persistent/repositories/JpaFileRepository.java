package com.sebapd.chat1b.server.adapters.persistent.repositories;

import com.sebapd.chat1b.server.adapters.persistent.entities.ChannelEntity;
import com.sebapd.chat1b.server.adapters.persistent.entities.FileEntity;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.util.Optional;

public class JpaFileRepository {

    @Setter
    @PersistenceContext
    EntityManager entityManager;

    private static final String DATA_DIR = "C:\\Users\\Seba\\Data\\";

    public void sendFile(FileEntity fileEntity, byte[] content, ChannelEntity channelEntity){
        var fileLocation = saveFile(content,fileEntity.getFileName());
        fileEntity.setContentLocation(fileLocation);
        entityManager.persist(fileEntity);
        channelEntity.getFileList().add(fileEntity);
        entityManager.merge(channelEntity);
    }

    public Optional<FileEntity> getFileByFileName(String fileName){
        try {
            return Optional.of((FileEntity) entityManager.createQuery("select a From FileEntity a where a.fileName like :name")
                    .setParameter("name", fileName).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String saveFile(byte[] content, String fileName){
        var fileLocation = DATA_DIR + fileName;
        File file = new File(fileLocation);
        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLocation;
    }

    public byte[] receiveFileContent(String fileLocation){
        byte[] content = new byte[0];
        try(var input = new FileInputStream(fileLocation)) {
            content =  input.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
