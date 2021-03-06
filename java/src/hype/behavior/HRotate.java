package hype.behavior;

import hype.interfaces.HRotatable;
import hype.util.HConstants;
import processing.core.PApplet;

public class HRotate extends HBehavior {
	protected HRotatable _target;
	protected float _speedRad;
	
	public HRotate() {}
	
	public HRotate(HRotatable newTarget, float dDeg) {
		target(newTarget);
		_speedRad = dDeg * HConstants.D2R;
	}
	
	public HRotate target(HRotatable r) {
		if(r == null) unregister();
		else register();
		
		_target = r;
		return this;
	}
	
	public HRotatable target() {
		return _target;
	}
	
	public HRotate speed(float dDeg) {
		_speedRad = dDeg * HConstants.D2R;
		return this;
	}
	
	public float speed() {
		return _speedRad * HConstants.R2D;
	}
	
	public HRotate speedRad(float dRad) {
		_speedRad = dRad;
		return this;
	}
	
	public float speedRad() {
		return _speedRad;
	}
	
	@Override
	public void runBehavior(PApplet app) {
		float rot = _target.rotationRad() + _speedRad;
		_target.rotationRad(rot);
	}
	
	@Override
	public HRotate register() {
		return (HRotate) super.register();
	}
	
	@Override
	public HRotate unregister() {
		return (HRotate) super.unregister();
	}
}
