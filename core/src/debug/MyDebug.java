package debug;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import comunes.Constantes;
import comunes.Teclado;
import interfaces.IObservable;
import interfaces.IObservador;

public class MyDebug extends Box2DDebugRenderer implements IObservador{
	Matrix4 debugMatrix;
	private boolean debug=false;
	
//	private IObservable observable;
	public MyDebug(IObservable observable) {
//		this.observable=observable;
		((Teclado)(observable)).addObserverDebug(this);
//		this.observable.addObserver(this);
	}

	public void draw(World world,SpriteBatch batch) {
		if(debug)
		this.render(world, batch.getProjectionMatrix().cpy().scale(Constantes.PIXELS_TO_METERS, Constantes.PIXELS_TO_METERS, 0));
		
	}

	@Override
	public void update() {
		debug=!debug;
	}
	
	
	
	
}
