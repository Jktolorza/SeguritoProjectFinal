--morosos
select cliente.id_cliente, cliente.nombreEmpresa as moroso, fechaVencimiento from factura
inner join cliente
on cliente.id_cliente = factura.cliente_id_cliente
where  sysdate > fechavencimiento
and extract(month from fechavencimiento) =(select to_char(sysdate,'mm') from dual);



--accidentes por cliente por mes
select cliente.id_cliente, cliente.nombreEmpresa, count(reporteaccidente.cliente_id_cliente) as accidentes
from reporteaccidente
inner join cliente
on cliente.id_cliente=reporteaccidente.cliente_id_cliente
where fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by cliente.id_cliente, cliente.nombreEmpresa;

--first and last day of the actual month
select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) as lastday from dual;
select trunc((sysdate),'month') as FirstDay from dual;

--accidentabilidad
select profesional.nombre, profesional.apellido, cliente.nombreempresa, count(reporteaccidente.id_reporteaccidente) as accidentes, count(distinct capacitacion.id_capacitacion) as capacitaciones, count(reporteaccidente.id_reporteaccidente)/count(distinct capacitacion.id_capacitacion) as indiceaccidentabilidad 
from reporteaccidente
inner join cliente
on cliente.id_cliente=reporteaccidente.cliente_id_cliente
inner join profesional
on reporteaccidente.profesional_id_profesional=profesional.id_profesional
inner join capacitacion
on capacitacion.profesional_id_profesional=profesional.id_profesional and capacitacion.cliente_id_cliente=cliente.id_cliente
where reporteaccidente.fecha between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
and capacitacion.fechayhora between (select trunc((sysdate),'month') from dual) and (select trim(to_date(last_day(sysdate),'DD/MM/YYYY')) from dual)
group by profesional.nombre, profesional.apellido, cliente.nombreEmpresa;


--accidentes por mes por profesional
--capacitaciones por mes por cliente
--capacitaciones por mes por profesional
--asesorias por mes por cliente
--asesorias por mes por profesional
--actividadesmejora por cliente
--actividadesmejora por profesional

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









