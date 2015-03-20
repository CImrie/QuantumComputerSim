package core;
import java.util.*;

public class ListQubit {
	List<ListState> qubit ;
	double magnitude;
	
	public ListQubit(Complex a, Complex b){
		ListState state1 = new ListState(0,a);
		ListState state2 = new ListState(1,b);
		MakeQubit(state1, state2);}
	
public void MakeQubit (ListState state1, ListState state2){
	List<ListState> qubit = new ArrayList<ListState>();
	if (state1.getValue().getRealPart()!=0){
		qubit.add(state1); //pair index & complex
	}
	if (state2.getValue().getRealPart()!=0){
		qubit.add(state2);
	}
	this.qubit=qubit;
}

public ListQubit(ListState s){
	if (s.getIndex()==0){
	MakeQubit(s, new ListState (1, new Complex (0,0)));}
	else if (s.getIndex()==1){
		MakeQubit(new ListState (1, new Complex (0,0)), s);}
	
	this.normalise();
}

public void normalise(){
	double sum=0; 
	for (int i=0; i<qubit.size(); i ++){
		sum += qubit.get(i).getValue().normSquared();
	}
	this.magnitude= Math.sqrt(sum);
	
	for (int i=0; i<qubit.size(); i ++){
		ListState normstate = new ListState( qubit.get(i).getIndex(), qubit.get(i).getValue().divideBy(this.magnitude) );
		qubit.set(i, normstate);
	}
	
}


public int getLength(){
	return qubit.size();
}

public int getIndex(int a){
	return qubit.get(a).getIndex();
}
	
}
