
--USUARIO
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$vhEGzaZMgJclASEdfRO3Be3ynPHsrt.XXKMYsFD3j6aAlBkbp1T.K', 'profesional','ROLE_PROFESIONAL');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$RpwEAhQUjkNwijvtG91Iku57FEWmhPepDxhcLEC.fZTbAyYVkCsWe', 'administrador','ROLE_ADMINISTRADOR');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$vTvacYsuAiEs4o/sgxmyiueSKi3I57p9cEztCMJtmNPDmjZlW2q92', 'cliente','ROLE_CLIENTE');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$ElrGfmIAfIGILpB6SngahupNu2tbtrZn4ihcw609dOaZEeP.fCQCy', 'mlillo','ROLE_PROFESIONAL');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$bqplfy/rXuHeKzX29U.PIeGpwi48yJyGP2V3yXpcoNBWRpDamaZCS', 'mflores','ROLE_PROFESIONAL');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$Dc4bEfo0vvXzC6DpPM1Ncuxso1jlBHtfAa8VzrsajtRADA7NuE.Ye', 'jtolorza','ROLE_PROFESIONAL');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$/jUyRyk6clGwagdmm7QMOuMc7esj0FH/pYin3wvf891Q/V.YpkNr.', 'clloncon','ROLE_PROFESIONAL');
INSERT INTO usuario(password,nickname, rol)
values ('$2a$10$P1XxIboELkfCBpos.2W.EOaTUe54CPSbY/tq13dmDWpewtpsRObaO', 'abarroso','ROLE_PROFESIONAL');

--CLIENTE

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Transportes S.A','77888999-9',TO_DATE('20/03/2020','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Mineria La Plata','78999000-0',TO_DATE('15/01/2020','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Bodegas Plastic','88000333-9',TO_DATE('10/05/2019','dd/mm/yyyy'), 'cliente',3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('O y R LTDA.','70654389-8',TO_DATE('24/08/2019','dd/mm/yyyy'), 'cliente',3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Constructora Central','76604493-1',TO_DATE('30/09/2019','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Envasados Gonzalez','75600500-2',TO_DATE('03/02/2019','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Baxter','77564321-9',TO_DATE('02/04/2020','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('General Motors','79560489-4',TO_DATE('07/05/2020','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Grupo Armour','78005338-1',TO_DATE('19/10/2019','dd/mm/yyyy'), 'cliente', 3);

INSERT INTO cliente (nombreempresa,rutempresa,fecharegistro, usuario_nickname, usuario_id_usuario)
values ('Quintino Express','76534765-2',TO_DATE('05/12/2019','dd/mm/yyyy'), 'cliente', 3);


--PROFESIONAL

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Jose','Mendoza','josemendoza@segurito.cl','977512400','Prevencionista de riesgo en terreno', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Lorena','Nunez','lorenanunez@segurito.cl','988877699','Coordinadora de calidad de vida laboral', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Cesar','Araneda','cesararaneda@segurito.cl','999800555','Jefe dpto. prevencion de riesgos laborales', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Rodrigo','Vasquez','rodrigovasquez@segurito.cl','900033378','Prevencionista de riesgo en terreno', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Alicia','Martinez','aliciamartinez@segurito.cl','977744455','Asesora en Prevencion de Riesgos', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Catalina','Rojas','catalinarojas@segurito.cl','966644433','Asesora en Prevencion de Riesgos', 'profesional', 1);

INSERT INTO profesional (nombre,apellido,correo,telefono,cargo, usuario_nickname, usuario_id_usuario)
values ('Daniel','Carrasco','danielcarrasco@segurito.cl','988900043','Prevencionista de riesgo en terreno', 'profesional', 1);

--ACTIVIDADES MEJORA

INSERT INTO actividadmejora (nombre,fechainicio,fechatermino,estado,detalle,profesional_id_profesional,cliente_id_cliente)
values ('Accidentes en superficies de trabajo',TO_DATE('01/02/2020','dd/mm/yyyy'),TO_DATE('02/03/2020','dd/mm/yyyy'),'Finalizado','Se reparan partes rotas del piso','4','2');

INSERT INTO actividadmejora (nombre,fechainicio,fechatermino,estado,detalle,profesional_id_profesional,cliente_id_cliente)
values ('Riesgos en operaciones de maquinas',TO_DATE('20/06/2020','dd/mm/yyyy'),TO_DATE('20/07/2020','dd/mm/yyyy'),'Pendiente','Pintar maquinas segun el codigo de colores','1','4');

--REPORTE ACCIDENTE

INSERT INTO reporteaccidente(fecha,direccion,labor,descripcion, profesional_id_profesional, cliente_id_cliente)
values (TO_DATE('02/05/2020','dd/mm/yyyy'),'Santa Marta 0344','Descarga de camion','Trabajador se dobla tobillo por suelo roto','1', '3');

INSERT INTO reporteaccidente(fecha,direccion,labor,descripcion,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('20/06/2020','dd/mm/yyyy'),'Departamental 769','Amago de incendio','Derrame de productos inflamables','2', '6');

--ASESORIA

INSERT INTO asesoria(fechayhora,motivo,detalle,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/05/2020 13:00','dd/mm/yyyy HH24:mi'),'Fiscalizacion','Repaso de los temas de seguridad y chequeo de cumplimiento','1','3');

INSERT INTO asesoria(fechayhora,motivo,detalle,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('01/03/2019 10:00','dd/mm/yyyy HH24:mi'),'Accidente','Revision de compensaciones y multas a las que se puede ver afecta la empresa','2','1');

--CAPACITACION
INSERT INTO capacitacion(fechayhora,tema,contenido,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('05/08/2020 12:00','dd/mm/yyyy HH24:mi'),'Seguridad en la oficina','Buenas practicas de seguridad','2','4');

INSERT INTO capacitacion(fechayhora,tema,contenido,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('02/05/2020 11:00','dd/mm/yyyy HH24:mi'),'Seguridad en faena','Buenas practicas de seguridad','4','3');

--FACTURA
INSERT INTO factura(fechacobro,fechavencimiento,extras, impuestos, subtotal, total, cliente_id_cliente)
values (TO_DATE('04/04/2020','dd/mm/yyyy'), TO_DATE('24/04/2020','dd/mm/yyyy'),300000,475000,2200000,2975000, '1');

INSERT INTO factura(fechacobro,fechavencimiento,extras, impuestos,subtotal, total, cliente_id_cliente)
values (TO_DATE('03/03/2020','dd/mm/yyyy'), TO_DATE('23/03/2020','dd/mm/yyyy'),400000,399000,1700000,2499000, '2');

--DETALLE FACTURA
INSERT INTO detallefactura(nombre,precio, cantidad, factura_id_factura)
values ('capacitacion', 400000,2,'1');

INSERT INTO detallefactura(nombre,precio, cantidad, factura_id_factura)
values ('asesoria', 300000,4,'1');

INSERT INTO detallefactura(nombre,precio, cantidad, factura_id_factura)
values ('callcenter', 200000,1,'1');

INSERT INTO detallefactura(nombre,precio, cantidad, factura_id_factura)
values ('asesoria', 300000,3,'2');

INSERT INTO detallefactura(nombre,precio, cantidad, factura_id_factura)
values ('capacitacion', 400000,2,'2');

--VISITA
INSERT INTO visita(fechavisita, numerovisita, profesional_id_profesional, cliente_id_cliente)
values(TO_DATE('02/05/2020 11:00','dd/mm/yyyy HH24:mi'),1,1,1);

--CHECKLIST
INSERT INTO checklist(version, visita_id_visita)
values (1,1);

--DETALLE CHECKLIST
INSERT INTO detallechecklist(descripcion, estado, checklist_id_checklist)
values ('Uso de zapatos de seguridad','No incorporado',1);



--ADMINISTRADOR

INSERT INTO administrador (nombre,usuario_id_usuario,usuario_nickname)
values ('Jorge Castillo','2','administrador');

--ASESORIA EXTRA

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,profesional_id_profesional, cliente_id_cliente)
values (TO_DATE('02/05/2020 13:00','dd/mm/yyyy HH24:mi'),'Asesoría autocuidado','Autocuidado laboral de trabajadores','1' ,'2');

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('05/06/2020 17:00','dd/mm/yyyy HH24:mi'),'Chequeo de instalaciones','Revision a nuevas instalaciones','2', '4');

INSERT INTO asesoriaextra (fechayhora,motivo,detalle,profesional_id_profesional,cliente_id_cliente)
values (TO_DATE('20/07/2020 10:00','dd/mm/yyyy HH24:mi'),'Asesoría emergencias','Se solicita asesoría para salidas de emergencia','3', '5');

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




