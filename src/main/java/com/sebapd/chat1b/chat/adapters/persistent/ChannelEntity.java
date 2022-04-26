package com.sebapd.chat1b.chat.adapters.persistent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class ChannelEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
}
