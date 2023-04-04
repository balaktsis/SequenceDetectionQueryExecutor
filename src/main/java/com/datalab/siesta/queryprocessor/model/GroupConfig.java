package com.datalab.siesta.queryprocessor.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupConfig implements Serializable {

    @JsonProperty("groups")
    private String groupsString;


    @JsonIgnore
    private List<Set<Long>> groups;

    public GroupConfig(){
        this.groupsString="";
        this.groups=new ArrayList<>();
    }

    public GroupConfig(String input) throws RuntimeException {
        this.groupsString=input;
        this.groups=this.parseGroups(input);
    }

    public void setGroups(String input) throws RuntimeException {
        this.groups=this.parseGroups(input);
    }

    public void setGroups(List<Set<Long>> groups){
        this.groups=groups;
    }

    @JsonIgnore
    public List<Set<Long>> getGroups() {
        return groups;
    }

    @JsonIgnore
    public String getGroupsString() {
        return groupsString;
    }

    public void setGroupsString(String groupsString) {
        this.groupsString = groupsString;
        this.groups=parseGroups(groupsString);
    }

    private List<Set<Long>> parseGroups(String input) throws RuntimeException {
        List<Set<Long>> response = new ArrayList<>();
        if(input.equals("")){
            return response;
        }
        Matcher m = Pattern.compile("\\(.*?\\)").matcher(input);
        try{
            while(m.find()){
                String s = m.group();
                List<Long> n= new ArrayList<>();
                String[] ids = s.subSequence(1,s.length()-1).toString().split(",");
                for(String id:ids){
                    if(id.contains("-")){
                        String[] numbers = id.split("-");
                        for(long i = Long.parseLong(numbers[0]); i<=Long.parseLong(numbers[1]);i++){
                            n.add(i);
                        }
                    }else{
                        n.add(Long.parseLong(id));
                    }
                }
                response.add(new HashSet<>(n));
            }
            return response;
        }catch(Exception e){
            throw new RuntimeException("The groups cannot be parsed");
        }
    }
}
