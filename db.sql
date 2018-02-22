CREATE DATABASE IF NOT EXISTS kopr;
USE kopr;

DROP TABLE IF EXISTS cvicenie;
CREATE TABLE IF NOT EXISTS cvicenie (
	uuid varchar(36) NOT NULL PRIMARY KEY, 
    nazovPredmetu varchar(100) NOT NULL,
    UNIQUE KEY(uuid, nazovPredmetu)
);

SELECT * FROM cvicenie;

-- Predmet Kryptografia sa nachadza v poziadavka klienta 
-- DELETE FROM cvicenie WHERE nazovPredmetu = 'Kryptografia';
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'KonkurentneProgramovanie');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'SoftveroveInzinierstvo');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'Algebra');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'PAZ1b');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'MatematickaAnalyza');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'PAZ1a');
INSERT INTO cvicenie (uuid, nazovPredmetu) VALUES (UUID(), 'DiskretnaMatematika');
