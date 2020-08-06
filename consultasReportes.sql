--morosos
select cliente.id_cliente, cliente.nombreEmpresa as moroso, fechaVencimiento from factura
inner join cliente
on cliente.id_cliente = factura.cliente_id_cliente
where  sysdate > fechavencimiento
and extract(month from fechavencimiento) =(select to_char(sysdate,'mm') from dual);

--accidentes por cliente por mes
select cliente.id_cliente, cliente.nombreEmpresa, count(reporteaccidente.id_reporteaccidente) as accidentes
from reporteaccidente
inner join cliente
on cliente.id_cliente=reporteaccidente.cliente_id_cliente
where fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by cliente.id_cliente, cliente.nombreEmpresa;

--accidentes por profesional por mes
select profesional.id_profesional , profesional.nombre, profesional.apellido, count(reporteaccidente.id_reporteaccidente) as accidentes
from reporteaccidente
inner join profesional
on profesional.id_profesional=reporteaccidente.profesional_id_profesional
where fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by profesional.id_profesional , profesional.nombre, profesional.apellido;

--asesorias por cliente por mes
select cliente.id_cliente, cliente.nombreEmpresa, count(asesoria.id_asesoria) as asesorias
from asesoria
inner join cliente
on cliente.id_cliente=asesoria.cliente_id_cliente
where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by cliente.id_cliente, cliente.nombreEmpresa;

--asesorias por profesional por mes
select profesional.id_profesional , profesional.nombre, profesional.apellido, count(asesoria.id_asesoria) as asesorias
from asesoria
inner join profesional
on profesional.id_profesional=asesoria.profesional_id_profesional
where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by profesional.id_profesional , profesional.nombre, profesional.apellido;

--capacitaciones por cliente por mes
select cliente.id_cliente, cliente.nombreEmpresa, count(capacitacion.id_capacitacion) as capacitaciones
from capacitacion
inner join cliente
on cliente.id_cliente=capacitacion.cliente_id_cliente
where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by cliente.id_cliente, cliente.nombreEmpresa;

--capacitaciones por profesional por mes
select profesional.id_profesional, profesional.nombre, profesional.apellido, count(capacitacion.id_capacitacion) as capacitaciones
from capacitacion
inner join profesional
on profesional.id_profesional=capacitacion.profesional_id_profesional
where fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by profesional.id_profesional , profesional.nombre, profesional.apellido;

--actividades de mejora por cliente por mes (solo chequeo de fecha de inicio)
select cliente.id_cliente, cliente.nombreEmpresa, count(actividadmejora.id_actividadmejora) as actividadmejora
from actividadmejora
inner join cliente
on cliente.id_cliente=actividadmejora.cliente_id_cliente
where fechainicio between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by cliente.id_cliente, cliente.nombreEmpresa;

--actividadesmejora por profesional por mes (solo chequeo de fecha de inicio)
select profesional.id_profesional, profesional.nombre, profesional.apellido, count(actividadmejora.id_actividadmejora) as actividadmejora
from actividadmejora
inner join profesional
on profesional.id_profesional=actividadmejora.profesional_id_profesional
where fechainicio between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by profesional.id_profesional , profesional.nombre, profesional.apellido;

--accidentabilidad
select profesional.id_profesional as id, profesional.nombre || ' ' || profesional.apellido as profesional, count(reporteaccidente.id_reporteaccidente)/count(distinct capacitacion.id_capacitacion) as indiceAccidentabilidad 
from reporteaccidente
inner join cliente
on cliente.id_cliente=reporteaccidente.cliente_id_cliente
inner join profesional
on reporteaccidente.profesional_id_profesional=profesional.id_profesional
inner join capacitacion
on capacitacion.profesional_id_profesional=profesional.id_profesional and capacitacion.cliente_id_cliente=cliente.id_cliente
where reporteaccidente.fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
and capacitacion.fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by  profesional.id_profesional, profesional.nombre || ' ' || profesional.apellido;







--first and last day of the actual month
select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) as lastday from dual;
select trunc((sysdate),'month') as FirstDay from dual;


--estas si sobra tiempo
--accidentes totales por mes y por cliente
select cliente.nombreempresa, count(cliente_id_cliente) as accidentespormes, extract(month from fecha) as mes 
from reporteaccidente
inner join cliente
on cliente.id_cliente=reporteaccidente.cliente_id_cliente
where fecha between to_date('2020-01-01', 'yyyy-mm-dd')
 and  (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
 group by cliente.nombreempresa, extract(month from fecha);

--capacitaciones por mes de un cliente
--asesorias por mes de un cliente
--actividadesmejora por mes de un cliente









