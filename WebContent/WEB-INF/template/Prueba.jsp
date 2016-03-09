<script>
	jQuery(function() {
		jQuery("#grid")
				.kendoGrid(
						{
							"dataSource" : {
								"schema" : {
									"total" : "total",
									"model" : {
										"id" : "idMuestraIndividual",
										"fields" : {
											"dt" : {
												"type" : "string"
											},
											"responsable" : {
												"type" : "string"
											},
											"idMuestraIndividual" : {
												"type" : "number"
											},
											"loteConcreto.codigo" : {
												"type" : "string"
											},
											"horaCalidadInicial" : {
												"type" : "date"
											},
											"requerimientoIncumplido" : {
												"type" : "string"
											},
											"estadoFinal" : {
												"type" : "string"
											},
											"estadoInicial" : {
												"type" : "string"
											},
											"causaNC" : {
												"type" : "string"
											},
											"tiempoFinDescarga" : {
												"type" : "number"
											},
											"tratamientoDestinoFinal" : {
												"type" : "string"
											},
											"tiempoEsperaObra" : {
												"type" : "number"
											},
											"mixer" : {
												"type" : "string"
											},
											"gr" : {
												"type" : "string"
											},
											"horaCalidadFinal" : {
												"type" : "date"
											}
										}
									},
									"data" : "data"
								},
								"transport" : {
									"read" : {
										"contentType" : "application/json",
										"url" : "muestraIndividualConcreto/getListaMuestraIndividual"
									}
								},
								"pageSize" : 10.0,
								"autoSync" : false
							},
							"filterable" : false,
							"sortable" : false,
							"pageable" : true,
							"columns" : [
									{
										"template" : "<input name='cxbMuestraIndividualConcreto' type='radio' class='radio'/>",
										"field" : "idMuestraIndividual",
										"title" : " ",
										"width" : "40px"
									},
									{
										"field" : "loteConcreto.codigo",
										"title" : "ID Lote",
										"width" : "140px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "dt",
										"title" : "DT",
										"width" : "80px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "gr",
										"title" : "GR",
										"width" : "80px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "mixer",
										"title" : "Mixer",
										"width" : "90px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "estadoInicial",
										"title" : "Estado Inicial",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "horaCalidadInicial",
										"title" : "Hora C. Calidad",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'",
										"format" : "{0:hh:mm tt}"
									},
									{
										"field" : "responsable",
										"title" : "Responsable",
										"width" : "140px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "requerimientoIncumplido",
										"title" : "Requisito / Par&aacute;metro Incumplido",
										"width" : "160px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "causaNC",
										"title" : "Causa NC",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "tratamientoDestinoFinal",
										"title" : "Tratamiento Destino Final",
										"width" : "145px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "estadoFinal",
										"title" : "Estado Final",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "horaCalidadFinal",
										"title" : "Hora C. Calidad",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'",
										"format" : "{0:hh:mm tt}"
									},
									{
										"field" : "tiempoEspera",
										"title" : "Tiempo Espera",
										"width" : "120px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									},
									{
										"field" : "tiempoDescarga",
										"title" : "Tiempo Descarga",
										"width" : "130px",
										"headerAttributes" : "style= 'white-space: pre-line;text-overflow: inherit'"
									} ],
							"scrollable" : true,
							"groupable" : false
						});
	})
</script>