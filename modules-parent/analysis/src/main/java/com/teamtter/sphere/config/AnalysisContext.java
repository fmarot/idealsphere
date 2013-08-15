package com.teamtter.sphere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teamtter.sphere.ISphereModule;
import com.teamtter.sphere.analysis.AnalysysModule;

@Configuration
public class AnalysisContext {
	@Bean
	ISphereModule module() {
		return new AnalysysModule();
	}
}
