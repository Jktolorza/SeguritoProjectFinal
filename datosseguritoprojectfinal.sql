--ADMINISTRADOR

INSERT INTO administrador (nombre,usuario_id_usuario,usuario_nickname)
values ('Jorge Castillo','2','administrador');

--ASESORIA EXTRA

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,cliente_id_cliente)
values (TO_DATE('02/05/2020 13:00','dd/mm/yyyy HH24:mi'),'Asesoría autocuidado','Autocuidado laboral de trabajadores','2');

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,cliente_id_cliente)
values (TO_DATE('05/06/2020 17:00','dd/mm/yyyy HH24:mi'),'Chequeo de instalaciones','Revision a nuevas instalaciones','4');

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,cliente_id_cliente)
values (TO_DATE('20/07/2020 10:00','dd/mm/yyyy HH24:mi'),'Asesoría emergencias','Se solicita asesoría para salidas de emergencia','5');

--VISITA

INSERT INTO visita(fechavisita, numerovisita, profesional_id_profesional, cliente_id_cliente)
values(TO_DATE('05/07/2020 14:00','dd/mm/yyyy HH24:mi'),1,3,4);

INSERT INTO visita(fechavisita, numerovisita, profesional_id_profesional, cliente_id_cliente)
values(TO_DATE('03/04/2020 10:00','dd/mm/yyyy HH24:mi'),1,5,6);

INSERT INTO visita(fechavisita, numerovisita, profesional_id_profesional, cliente_id_cliente)
values(TO_DATE('15/07/2020 16:00','dd/mm/yyyy HH24:mi'),1,2,3);

--CHECKLIST

INSERT INTO checklist(version, visita_id_visita)
values (1,2);

INSERT INTO checklist(version, visita_id_visita)
values (1,3);

INSERT INTO checklist(version, visita_id_visita)
values (1,4);

--DETALLE CHECKLIST

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Revision nuevas instalaciones','Resuelto',1);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Mejoras en señalizaciones de seguridad','Resuelto',1);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Señalizacion de espacios peligrosos','No incorporado',2);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Entrega de ropa de seguridad a trabajadores','Resuelto',2);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Señalizacion salidas de emergencia','No incorporado',2);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Instalaciones electricas en mal estado','No incorporado',3);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Equipos ergonomicos en mobiliario','Resuelto',3);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Entrega de equipo de seguridad a trabajadores','No incorporado',3);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Instalacion sistema de alarmas','No incorporado',4);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Control de accesos a personal autorizado','No incorporado',4);

INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Mantencion de areas identificadas y ordenadas','Resuelto',4);

--REPORTECLIENTE

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('02/05/2020','dd/mm/yyyy'),'1','0','1','1');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('03/06/2020','dd/mm/yyyy'),'0','0','2','3');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('05/04/2020','dd/mm/yyyy'),'2','0','3','2');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('05/07/2020','dd/mm/yyyy'),'0','1','4','4');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('02/07/2020','dd/mm/yyyy'),'2','0','5','6');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('05/05/2020','dd/mm/yyyy'),'0','1','6','5');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('01/06/2020','dd/mm/yyyy'),'1','0','7','7');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('05/06/2020','dd/mm/yyyy'),'0','0','8','4');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('03/05/2020','dd/mm/yyyy'),'2','0','9','5');

INSERT INTO reportecliente(periodo,indiceaccidentabilidad,morosidad,cliente_id_cliente,profesional_id_profesional)
values (TO_DATE('05/07/2020','dd/mm/yyyy'),'0','1','10','1');

--REPORTEGLOBAL

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('05/07/2020','dd/mm/yyyy'),'1','1','2','1','1');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/07/2020','dd/mm/yyyy'),'0','2','1','3','2');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('03/06/2020','dd/mm/yyyy'),'2','1','1','2','3');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('01/06/2020','dd/mm/yyyy'),'1','1','1','4','4');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/07/2020','dd/mm/yyyy'),'2','2','3','6','5');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('03/07/2020','dd/mm/yyyy'),'1','2','2','5','6');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('05/05/2020','dd/mm/yyyy'),'3','3','3','7','7');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('01/05/2020','dd/mm/yyyy'),'1','1','0','4','8');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/07/2020','dd/mm/yyyy'),'1','1','3','5','9');

INSERT INTO reporteglobal(periodo,cantidadcapacitacion,cantidadasesorias,cantidadactividades,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/07/2020','dd/mm/yyyy'),'3','1','3','1','10');




