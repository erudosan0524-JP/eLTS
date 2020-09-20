package com.github.jp.erudo.elts.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamConfig {

	private CustomConfig config;

	private Set<String> teams;
	private HashMap<String, List<String>> teamMembers;

	public TeamConfig(CustomConfig config) {
		this.config = config;

		this.teams = new HashSet<String>();
		this.teamMembers = new HashMap<String, List<String>>();

		load();
	}

	private void load() {
		if(config != null) {
			config.reloadConfig();
		}

		for(String key : config.getConfig().getKeys(false)) {
			teams.add(key);

			teamMembers.put(key, config.getConfig().getStringList(key));
		}
	}

	public Set<String> getTeams() {
		return teams;
	}

	public void setTeams(Set<String> teams) {
		this.teams = teams;
	}

	public List<String> getTeamMembers(String key) {
		return teamMembers.get(key);
	}

	public void addTeamMember(String key, List<String> value) {
		this.teamMembers.put(key,value);
	}

	public void reload() {
		config.reloadConfig();
	}



}
