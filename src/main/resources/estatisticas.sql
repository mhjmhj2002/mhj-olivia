select entrada, variavel, fixo, variavel + fixo as total_gastos,
(100*variavel/entrada)as perc_variavel, (100*fixo/entrada) as perc_fixo, (100*(fixo + variavel)/entrada) as perc_total,
investimento, entrada_desconhecida, saida_desconhecida
from (
(SELECT SUM(od.valor) as variavel 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'V'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00') as variavel
,
(SELECT SUM(od.valor) as fixo 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'F'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00') as fixo
, 
(SELECT SUM(od.valor) as entrada 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'E'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00') as entrada
, 
(SELECT SUM(od.valor) as investimento 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'I'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00') as investimento
, 
(SELECT SUM(od.valor) as entrada_desconhecida 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'D'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00'
and od.valor > 0) as entrada_desconhecida
, 
(SELECT SUM(od.valor) as saida_desconhecida 
FROM categoria_olivia co, olivia_data od 
where co.id = od.categoria_olivia_id 
and co.tipo_gasto = 'D'
and od.data between '2021-09-01 00:00:00' and '2021-10-01 00:00:00'
and od.valor < 0) as saida_desconhecida
);