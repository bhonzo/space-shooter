package com.bhonzo.shooter.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bhonzo.shooter.Weapon;

public class weaponTest {

	@Test
	public void weaponCreate() {
	
		
		
		int numInitialAmmo = 10; 
		int maxAmmoCapacity = 30;
		float firingRate = 2; //2 per sec 
		Weapon ak47 = new Weapon(numInitialAmmo,maxAmmoCapacity,firingRate );
		
		assertEquals(ak47.getNumberOfCurentAmmo(),10);
		assertEquals(ak47.getAmmoCapacity(),30);
		assertEquals(ak47.getFiringRate()==2,true);
		ak47.fire();
		assertEquals(ak47.getNumberOfCurentAmmo(),9);
		ak47.reload(); 
		assertEquals(ak47.getNumberOfCurentAmmo(),ak47.getAmmoCapacity());
		
		
	}

}
