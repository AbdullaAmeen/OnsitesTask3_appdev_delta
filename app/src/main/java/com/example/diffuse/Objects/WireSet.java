package com.example.diffuse.Objects;



import android.graphics.RectF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WireSet {
    public final static int WIRES =6,WIRE_GROUPS=3,WIRE_GROUP_SIZE=2,COLOR_RED=0,COLOR_GREEN=2,COLOR_BLUE=1, COLOR_HOLDER=9;
    private List<Integer> wireRandomList;
    private List<Integer> wireCorrectList;
    private List<Wire> wireList;
    private List<Wire> wireHolderList;



    public WireSet(Box minScreen) {
        initializeWiresSet();
        initializeWires(minScreen);
        initializeHolders(minScreen);

    }

    private void initializeWires(Box minScreen) {
        wireList=new ArrayList<>(WIRES);
        int j=1;
        for(Integer i: wireRandomList){

                RectF cords = minScreen.getCords();
                float y =(cords.bottom-cords.top)/(WIRES +1);
                float x = cords.left;
                wireList.add(new Wire(new Box(Wire.WIRE_WIDTH,cords.width(),x ,cords.top + j*y- Wire.WIRE_WIDTH/2f),i));
                j++;
        }
    }
    private void initializeHolders(Box minScreen) {
        wireHolderList=new ArrayList<>(WIRES);
        for(int i=0; i<WIRES; i++){
            RectF cords = minScreen.getCords();
            float y = (cords.bottom-cords.top)/(WIRES +1);
            float x = cords.left;
            wireHolderList.add(new Wire(new Box(Wire.HOLDER_WIDTH,cords.width(),x ,cords.top +(i+1)*y- Wire.HOLDER_WIDTH/2f),COLOR_HOLDER));
        }
    }
    private void initializeWiresSet() {
        wireRandomList = new ArrayList<>();
        for(int i =0; i<3; i++){
            for(int j =0; j<2; j++){
                wireRandomList.add(i);
            }
        }
        Collections.shuffle(wireRandomList);
        getCorrectWireList();
    }

    private void getCorrectWireList() {
        wireCorrectList = new ArrayList<>();
        for(Integer i: wireRandomList){
            if(!wireCorrectList.contains(i))
                wireCorrectList.add(i);
        }
    }

    public List<Integer> getWireRandomList() {
        return wireRandomList;
    }

    public void setWireRandomList(List<Integer> wireRandomList) {
        this.wireRandomList = wireRandomList;
    }

    public List<Integer> getWireCorrectList() {
        return wireCorrectList;
    }

    public void setWireCorrectList(List<Integer> wireCorrectList) {
        this.wireCorrectList = wireCorrectList;
    }

    public List<Wire> getWireList() {
        return wireList;
    }

    public void setWireList(List<Wire> wireList) {
        this.wireList = wireList;
    }

    public List<Wire> getWireHolderList() {
        return wireHolderList;
    }

    public void setWireHolderList(List<Wire> wireHolderList) {
        this.wireHolderList = wireHolderList;
    }
}
