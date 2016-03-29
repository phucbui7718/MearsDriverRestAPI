package com.mears.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="counters")
@TypeAlias("IdCounter")
public class IdCounter {

    @Id
    private String id;
    private long sequenceValue;

    public IdCounter(String id, long sequenceValue ) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

    public void setSequenceValue(long value) {
        this.sequenceValue = value;
    }

    public long getNextSequenceValue(){
        this.setSequenceValue(this.sequenceValue += 1);
        return this.sequenceValue;
    }

    public String toString() {
        return "_id: " + this.id + " / sequenceValue: " + this.sequenceValue;
    }
}
