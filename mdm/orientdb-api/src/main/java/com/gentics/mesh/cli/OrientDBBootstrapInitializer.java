package com.gentics.mesh.cli;

import com.gentics.mesh.annotation.Getter;
import com.gentics.mesh.core.data.root.MeshRoot;
import com.gentics.mesh.core.data.root.RootResolver;

public interface OrientDBBootstrapInitializer extends BootstrapInitializer {

	@Getter
	MeshRoot meshRoot();
	
	@Override
	default RootResolver rootResolver() {
		return meshRoot();
	}
}