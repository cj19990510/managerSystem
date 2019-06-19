<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>报名参赛页面</title>
<link rel="stylesheet" href="js/select_partner_js/jquery-ui.css">
<script src="js/select_partner_js/jquery-1.10.2.js"></script>
<script src="js/select_partner_js/jquery-ui.js"></script>
<link href="css/normalize.css" rel="stylesheet" />
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>

<style type="text/css">
body {
	font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
	color: #222;
	background: url(pattern.png);
	overflow-y: scroll;
	padding: 60px 0 0 0;
}

#my-form {
	width: 755px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 3em;
	border-radius: 3px;
	box-shadow: 0 0 2px rgba(0, 0, 0, .2);
}

#comments {
	width: 350px;
	height: 100px;
}

.custom-combobox {
	position: relative;
	display: inline-block;
}

.custom-combobox-toggle {
	position: absolute;
	top: 0;
	bottom: 0;
	margin-left: -1px;
	padding: 0;
	width: 23px;
}

.custom-combobox-input {
	margin: 0;
	padding: 3px 0px;
}
</style>
<script>
	(function($) {
		$.widget("custom.combobox", {
			_create : function() {
				this.wrapper = $("<span>")
					.addClass("custom-combobox")
					.insertAfter(this.element);

				this.element.hide();
				this._createAutocomplete();
				this._createShowAllButton();
			},

			_createAutocomplete : function() {
				var selected = this.element.children(":selected"),
					value = selected.val() ? selected.text() : "";

				this.input = $("<input>")
					.appendTo(this.wrapper)
					.val(value)
					.attr("title", "")
					.addClass("custom-combobox-input ui-widget-content ui-state-default ui-corner-left")
					.autocomplete({
						delay : 0,
						minLength : 0,
						source : $.proxy(this, "_source")
					})
					.tooltip({
						tooltipClass : "ui-state-highlight"
					});

				this._on(this.input, {
					autocompleteselect : function(event, ui) {
						ui.item.option.selected = true;
						this._trigger("select", event, {
							item : ui.item.option
						});
					},

					autocompletechange : "_removeIfInvalid"
				});
			},

			_createShowAllButton : function() {
				var input = this.input,
					wasOpen = false;

				$("<a>")
					.attr("tabIndex", -1)
					.attr("title", "Show All Items")
					.tooltip()
					.appendTo(this.wrapper)
					.button({
						icons : {
							primary : "ui-icon-triangle-1-s"
						},
						text : false
					})
					.removeClass("ui-corner-all")
					.addClass("custom-combobox-toggle ui-corner-right")
					.mousedown(function() {
						wasOpen = input.autocomplete("widget").is(":visible");
					})
					.click(function() {
						input.focus();

						// Close if already visible
						if (wasOpen) {
							return;
						}

						// Pass empty string as value to search for, displaying all results
						input.autocomplete("search", "");
					});
			},

			_source : function(request, response) {
				var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
				response(this.element.children("option").map(function() {
					var text = $(this).text();
					if (this.value && (!request.term || matcher.test(text)))
						return {
							label : text,
							value : text,
							option : this
						};
				}));
			},

			_removeIfInvalid : function(event, ui) {

				// Selected an item, nothing to do
				if (ui.item) {
					return;
				}

				// Search for a match (case-insensitive)
				var value = this.input.val(),
					valueLowerCase = value.toLowerCase(),
					valid = false;
				this.element.children("option").each(function() {
					if ($(this).text().toLowerCase() === valueLowerCase) {
						this.selected = valid = true;
						return false;
					}
				});

				// Found a match, nothing to do
				if (valid) {
					return;
				}

				// Remove invalid value
				this.input
					.val("")
					.attr("title", value + " didn't match any item")
					.tooltip("open");
				this.element.val("");
				this._delay(function() {
					this.input.tooltip("close").attr("title", "");
				}, 2500);
				this.input.autocomplete("instance").term = "";
			},

			_destroy : function() {
				this.wrapper.remove();
				this.element.show();
			}
		});
	})(jQuery);

	$(function() {
		$("#sub_tea_id_select").combobox();
		$("#toggle").click(function() {
			$("#sub_tea_id_select").toggle();
		});
	});
</script>
</head>
<body>
	<div class="row">
		<div class="eightcol last">

			<!-- Begin Form -->
			<s:set name="studentMessage" value="#session.studentMessage"></s:set>
			<select id="sub_tea_id_select">
				<option value="00001">00001</option>
				<option value="00002">00002</option>
				<option value="00003">00003</option>
				<option value="11001">11001</option>
				<option value="11002">11002</option>
				<option value="11003">11003</option>
				<option value="11061032">11061032</option>
			</select>

			<form id="my-form" action="StudentAttendContest" method="post">



				<section name="1.选择比赛">
					<div>
						<label>近期比赛:</label>
						<s:iterator value="#session.currentContestInfo" var="var">
							<label><input type="radio" name="contest_choose"
								value="<s:property value="#var.CName"/>" />
							<s:property value="#var.CName" /></label>
						</s:iterator>
					</div>
				</section>

				<section name="2.个人信息填写">
					<div>
						<label>姓名:</label> <input name="workMessage.CStuName"
							type="text"
							value="<s:property value="#studentMessage.CName"></s:property>" />
					</div>
					<div>
						<label>学号:</label> <input name="" type="text"
							value="<s:property value="#studentMessage.CStuId"></s:property>" />
					</div>
					<div>
						<label>班级:</label><input name="" type="text"
							value="<s:property value="#studentMessage.CClass"></s:property>" />
					</div>
					<div>
						<label>电话:</label><input name="" type="text"
							value="<s:property value="#studentMessage.CPhone"></s:property>" />
					</div>
					<div>
						<label>QQ:</label> <input name="" type="text"
							value="<s:property value="#studentMessage.CQq"></s:property>" />
					</div>
					<div>
						<label>Email:</label><input name="email"
							data-ideal="required email" type="email"
							value="<s:property value="#studentMessage.CMail"></s:property>" />
					</div>
					<div>
						<label>队伍中文名称:</label><input id="teamName"
							onmouseleave="cheInput()" name="workMessage.CTeamName"
							type="text" />
					</div>
					<div>
						<label>队伍英文名称:</label><input name="workMessage.CTeamNameEn"
							type="text" />
					</div>
				</section>



				<section name="3.选择队友">
					<div>
						<label>队友1:</label><input type="tel" name="partner1" />
					</div>
					<div>
						<label>队友2:</label><input type="tel" name="partner2" />
					</div>
					<div>
						<label>队友3:</label><input type="tel" name="partner3" />
					</div>
					<div>
						<label>队友4:</label><input type="tel" name="partner4" />
					</div>
					<div>
						<label>是否团队参赛:</label> <select id="states" name="states">
							<option value="1" selected="selected">是</option>
							<option value="0">否</option>
						</select>
					</div>

					<div>
						<label>指导老师:</label> <select id="states" name="teacher_id">
							<s:iterator value="#session.teacherInfo" var="teacher">
								<option value="<s:property value="#teacher.CName"/>"><s:property value="#teacher.CName"/></option>
							</s:iterator>
						</select>
					</div>
					<div>
						<label>说明:</label>
						<textarea id="comments" name="comments"></textarea>
					</div>
				</section>
				<div>
					<hr />
				</div>

				<center>
					<div>
						<button type="submit">提交</button>
						<button id="reset" type="button">重置</button>
					</div>
				</center>
			</form>
			<!-- End Form -->

		</div>
	</div>

	<script>
		function cheInput() {
			var teamName = document.getElementById('teamName');
	
			if (teamName.value.length <= 4) {
				alert("teamName--不能太过简单");
			}
		}
	</script>


	<script type="text/javascript">
var options = {

	onFail: function(){
		alert( $myform.getInvalid().length +'å¤  éæ³å­æ®µ. Please check it.' )
	},

	inputs: {
		'password': {
			filters: 'required pass',
		},
		'username': {
			filters: 'required username',
			data: {
			//ajax: { url:'validate.php' }
			}
		},
		'file': {
			filters: 'extension',
			data: { extension: ['jpg'] }
		},
		'comments': {
			filters: 'min max',
			data: { min: 50, max: 200 }
		},
		'states': {
			filters: 'exclude',
			data: { exclude: ['default'] },
			errors : {
				exclude: 'éæ©å½ç±.'
			}
		},
		'langs[]': {
			filters: 'min max',
			data: { min: 2, max: 3 },
			errors: {
				min: 'Check at least <strong>2</strong> options.',
				max: 'No more than <strong>3</strong> options allowed.'
			}
		}
	}
	
};

var $myform = $('#my-form').idealforms(options).data('idealforms');

$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});

$myform.focusFirst();
</script>
	<div style="text-align:center;"></div>
</body>
</html>