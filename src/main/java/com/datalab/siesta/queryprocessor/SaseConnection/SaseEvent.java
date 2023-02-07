package com.datalab.siesta.queryprocessor.SaseConnection;

import edu.umass.cs.sase.stream.ABCEvent;
import edu.umass.cs.sase.stream.Event;
import scala.reflect.internal.Trees;

public class SaseEvent implements Event {

    private int trace_id;
    private int position;

    private String eventType;
    private int timestamp;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTrace_id() {
        return trace_id;
    }

    public void setTrace_id(int trace_id) {
        this.trace_id = trace_id;
    }

    @Override
    public int getAttributeByName(String attributeName) {
        if(attributeName.equalsIgnoreCase("position"))
            return position;
        if(attributeName.equalsIgnoreCase("timestamp"))
            return timestamp;
        if(attributeName.equalsIgnoreCase("trace_id"))
            return trace_id;
        return -1;
    }

    @Override
    public double getAttributeByNameDouble(String attributeName) {
        return 0;
    }

    @Override
    public String getAttributeByNameString(String attributeName) {
        return null;
    }

    @Override
    public int getAttributeValueType(String attributeName) {
        return 0;
    }

    @Override
    public int getId() {
        return position;
    }

    @Override
    public void setId(int Id) {
        position=Id;
    }

    @Override
    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    @Override
    public Object clone() {
        SaseEvent o = null;
        try {
            o = (SaseEvent)super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return o;
    }
}
