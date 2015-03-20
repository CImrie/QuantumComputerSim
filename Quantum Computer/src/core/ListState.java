package core;

public class ListState {
int index;
Complex c;

public ListState (int index, Complex c){
	this.index=index;
	this.c=c;
}

public ListState (int type){
	if (type==0){
	this.index=0;
	this.c=new Complex(1,0);
	}
	else if (type==1){
		this.index=1;
		this.c=new Complex(1,0);
		}

}

public Complex getValue(){
	return c;
}

public int getIndex(){
	return index;
}

}
