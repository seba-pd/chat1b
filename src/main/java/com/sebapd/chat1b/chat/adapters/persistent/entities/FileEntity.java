package com.sebapd.chat1b.chat.adapters.persistent.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Setter
@Getter
@Table(name = "file")
public class FileEntity {
    @Id
    @Column(name = "file_id", nullable = false)
    private UUID fileId;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "fileName",nullable = false)
    private String fileName;
    @Column(name = "content_location",nullable = false)
    private String contentLocation;
    @Column(name = "creation_time",nullable = false)
    private Timestamp createTime;

}
