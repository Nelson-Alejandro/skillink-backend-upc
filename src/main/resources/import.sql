-- ======================================================
-- IMPORT.SQL — SKILLINK (POSTGRESQL)
-- ======================================================
-- ======================================================

-- -------------------------------
-- ROLES BASE
-- -------------------------------
INSERT INTO roles (name)
SELECT 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'ADMIN');

INSERT INTO roles (name)
SELECT 'USUARIO'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'USUARIO');

INSERT INTO roles (name)
SELECT 'ASESOR'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'ASESOR');

-- -------------------------------
-- ADMINISTRADOR INICIAL (ÚNICO)
-- -------------------------------
INSERT INTO administrador (
    nombreadmin,
    correoadmin,
    telefonoadmin,
    direccionadmin,
    "password"
)
SELECT
    'admin',
    'admin@skilllink.com',
    999999999,
    'Dirección Admin',
    '$2a$12$cXhXsdtDBEH8vBHzHBo2Vey/y/g22UDWVLi.h91JRk32.cPSGvjsa'
WHERE NOT EXISTS (
    SELECT 1
    FROM administrador
    WHERE correoadmin = 'admin@skilllink.com'
);

-- -------------------------------
-- USER LOGIN DEL ADMIN
-- -------------------------------
INSERT INTO users (
    username,
    password
)
SELECT
    'admin',
    '$2a$12$cXhXsdtDBEH8vBHzHBo2Vey/y/g22UDWVLi.h91JRk32.cPSGvjsa'
WHERE NOT EXISTS (
    SELECT 1
    FROM users
    WHERE username = 'admin'
);

-- -------------------------------
-- ASIGNACIÓN ROL ADMIN
-- -------------------------------
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.name = 'ADMIN'
WHERE u.username = 'admin'
  AND NOT EXISTS (
    SELECT 1
    FROM user_roles ur
    WHERE ur.user_id = u.id
      AND ur.role_id = r.id
);