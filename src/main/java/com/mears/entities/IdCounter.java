package com.mears.entities;

import com.mears.repositories.IdCounterRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="counters")
@TypeAlias("IdCounter")
public class IdCounter {

    @Id
    private String id;
    private long sequenceValue;
    private IdCounterRepository idCounterRepository;

    public IdCounter(String id, long sequenceValue ) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

    public void setSequenceValue(long value) {
        this.sequenceValue = value;
    }

    public long getNextSequenceValue(){
        this.sequenceValue += 1;
        return this.sequenceValue;
    }

    public long peekNextSequenceValue(){
        return this.sequenceValue + 1;
    }
}
