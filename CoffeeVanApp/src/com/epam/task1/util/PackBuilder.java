package com.epam.task1.util;

import com.epam.task1.entity.pack.Pack;
import com.epam.task1.entity.pack.PackMaterial;
import com.epam.task1.entity.pack.PackSize;

public class PackBuilder
{
	public Pack createPack( PackMaterial packMaterial, PackSize packSize )
	{
		return new Pack( packMaterial, packSize );
	}
	
	public Pack createPack( PackMaterial packMaterial, double width, double height, double length)
	{
		return new Pack(packMaterial, width, height, length);
	}
	
}
