package fr.fidtec.database.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumération listant les SGBDRs courants et l'utilisation de creds.
 */
@RequiredArgsConstructor
@Getter
public enum SGBDR {

	GENERIC("GENERIC", Boolean.FALSE),
	H2DB("H2DB", Boolean.FALSE),
	MARIADB("MARIADB", Boolean.TRUE),
	POSTGRES("POSTGRES", Boolean.TRUE);
	
	private final String databaseName;
	private final Boolean useCredentials;

}
