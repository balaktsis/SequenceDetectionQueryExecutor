package com.datalab.siesta.queryprocessor.model.Patterns;

import com.datalab.siesta.queryprocessor.model.Constraints.Constraint;
import com.datalab.siesta.queryprocessor.model.Events.Event;
import com.datalab.siesta.queryprocessor.model.Events.EventPair;
import com.datalab.siesta.queryprocessor.model.Events.EventPos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SIESTAPattern {

    protected Set<EventPair> extractPairsAll(List<EventPos> events, List<Constraint> constraints){
        Set<EventPair> eventPairs = new HashSet<>();
        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = i+1; j < events.size(); j++) {
                EventPair n = new EventPair(events.get(i), events.get(j));
                Constraint c = this.searchForConstraint(i, j,constraints);
                if (c != null) n.setConstraint(c);
                eventPairs.add(n);
            }
        }
        return eventPairs;
    }

    protected Constraint searchForConstraint(int posA, int posB, List<Constraint> constraints) {
        for (Constraint c : constraints) {
            if (c.getPosA() == posA && c.getPosB() == posB) {
                return c;
            }
        }
        return null;
    }

    protected Set<EventPair> extractPairsConsecutive(List<EventPos> events,List<Constraint> constraints){
        Set<EventPair> eventPairs = new HashSet<>();
        for(int i =0 ; i< events.size()-1; i++){
            EventPair n = new EventPair(events.get(i), events.get(i+1));
            Constraint c = this.searchForConstraint(i, i+1,constraints);
            if (c != null) n.setConstraint(c);
            eventPairs.add(n);
        }
        return eventPairs;
    }

    protected void fixConstraints(List<Constraint> constraints) {
        for (Constraint c : constraints) {
            for (int i = c.getPosA() + 1; i < c.getPosB(); i++) {
                Constraint c1 = c.clone();
                c1.setPosA(c.getPosA());
                c1.setPosB(i);
                constraints.add(c1);
            }
        }
    }
}
