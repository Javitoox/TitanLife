alter table usuarios add constraint PassIgualConfirmPass check (pass = retypePass);

alter table usuarios add constraint Correo_Usuario check (regexp_like(email, '.*@.*\..+'));

alter table usuarios add constraint chequea_Pass check (REGEXP_LIKE(pass, '[a-zA-Z]\w{8,}'));

alter table usuarios add constraint caractEspecial_Username check (REGEXP_LIKE(username, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));

alter table usuarios add constraint caractEspecial_Age check (REGEXP_LIKE(age, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));

alter table usuarios add constraint caractEspecial_Height check (REGEXP_LIKE(height, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));

alter table usuarios add constraint caractEspecial_Weight check (REGEXP_LIKE(weight, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));

alter table usuarios add constraint caractEspecial_Hip check (REGEXP_LIKE(hip, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));

alter table usuarios add constraint caractEspecial_Waist check (REGEXP_LIKE(waist, '^[^_$%&|<>#!¡()*+,-./\:;><=@[]{}´|·~¬''?¿"ªº]*$'));
