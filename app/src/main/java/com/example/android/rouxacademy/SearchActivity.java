package com.example.android.rouxacademy;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity extends ActionBarActivity {

	// Declare Variables
	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;


	ArrayList<Case> arraylist = new ArrayList<Case>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);

		// Generate sample data



		list = (ListView) findViewById(R.id.listview);
		arraylist.add(new Case(R.drawable.image_20103, "الارتجاج", "1.\tإذا فقد المصاب وعيه ولو لمدة قصيرة أو تقيء ، اعمل على نقله إلى المستشفى.\n" +
				"2.\tاطلب منه الراحة، واضغط بشيء بارد مكان الإصابة.\n",R.drawable.image_20103));


		arraylist.add(new Case(R.drawable.image_30104, "انخفاض حرارة", "1.\tقد يصاب المصاب بارتعاش، وشحوب و برد، أو مشوشا\n" +
				"2.\tاطلب الإسعاف بأسرع وقت.\n" +
				"3.\tقم بتدفئة المصاب، وإذا كان واعيا، أعطه القليل من المشروب أو الحساء الدافئ.\n",R.drawable.image_20103));

		arraylist.add(new Case(R.drawable.image_40101, "التهاب السحايا", "1.\tقد يعاني المصاب من تصلب في الرقبة، أو أعراض تشبه أعراض تشبه الانفلونزا، وآلام في العضلات والمفاصل، وصداع، ارتفاع درجة الحرارة ، ومن الممكن أن يصبح حساس من الضوء.\n" +
				"2.\tفي حال ملاحظة تلك الأعراض، اتصل بالإسعاف.\n" +
				"3.\tطمئن المصاب باستمرار حتى وصول العون الطبي.\n",0));


		arraylist.add(new Case(R.drawable.image_20102, "اختناق", "1.\tأخرج أي بقايا أو أسنان اصطناعية من فم المصاب بإصبعيك، وحثه على السعال.\n" +
				"2.\tإذا لم يتزحزح الجسم الغريب بالسعال ،ساعد المصاب على الانحناء، بحيث يكون رأسه أدنى من رئتيه، اضربه بقوة على ظهره بين عظمتي الكتف براحة يدك وكرر ذلك 5 مرات، وأتبعها بخمس ضغطات سريعة على البطن.\n" +
				"3.\tللرضع (أصغر من سنة) \n" +
				"-\tضع الرضيع على ساعديك، ورأسه وصدره وبطنه متجهة إلى الأسفل، \n" +
				"-\tاضرب بقوة على ظهره 5 مرات بين ألواح الكتف ،\n" +
				"-\t ثم اضغط على الصدر 5 مرات ، باستخدام السبابة والوسطى على أعلى البطن (بين السرة وعظم القص)، واضغط بسرعة نحو الداخل وإلى الأعلى.\n" +
				"-\tكرر العملية حتى يخرج الجسم الغريب، أو عند سماع بكاء الرضيع.\n",R.drawable.cho));


		arraylist.add(new Case(R.drawable.image_40102, "تسمم", "1.\tاسأل المصاب الواعي بسرعة عما حدث، ولا تنس أنه قد يفقد وعيه بأي لحظة.\n" +
				"2.\tاعمل على نقله بسرعة إلى المستشفى، وأرسل معه عينة من القيء أو أي وعاء كالقوارير أو علب الأقراص التي تجدها بقربه.\n" +
				"3.\tلا تعط المصاب أي شيء ليشربه، ولا تدفعه إلى القيء. \n",0));

		arraylist.add(new Case(R.drawable.image_20101, "حروق", "1.\tبرد المنطقة المحروقة بمياه باردة جارية لمدة عشر دقائق على الأقل.\n" +
				"2.\tإذا كان الحرق يتطلب المزيد من العناية الطبية، غط الحرق بدون إحكام بغلاف بلاستيكي أو كيس بلاستيكي نظيف.\n" +
				"3.\tفي حال الضرورة اتصل بالإسعاف.\n",R.drawable.burn1));
		arraylist.add(new Case(R.drawable.image_30103, " حرق الشمس", "1.\tقد يكون جلد المصاب أحمر طريا، ومتورما، وقد يعاني من فقدان الوعي وارتفاع درجة الحرارة,\n" +
				"2.\tضع المصاب بالظل، أزل الملابس الضيقة ، وبرد جلده وذلك بمسحه بلطف بالماء البارد.\n" +
				"3.\tأعطه القليل من الماء للشرب على فترات متقاربة، تأكد من أن يشرب الماء ببطء.\n" +
				"4.\tاطلب العون الطبي.\n",0));

		arraylist.add(new Case(R.drawable.image_10101, "حساسية", "1.\tقد يتشكل طفح جلدي على المصاب ، وتورم أو حكة على يديه و قدميه أو على وجهه. وقد يتباطأ التنفس .\n" +
				"2.\tعندما تلاحظ هذه الأعراض، اتصل بالإسعاف.\n" +
				"3.\tإذا كنت تعلم نوع الحساسية المصاب، ولديه مضاد حساسية، يمكنك مساعدته بإعطائه منه\n" +
				"4.\tطمئن المصاب باستمرار إلى حين وصول سيارة الاسعاف.\n",0));



		arraylist.add(new Case(R.drawable.image_30102, "ذبحة قلبية","1.\t قد يشعر المصاب بألم في الصدر والأصابع، وقد يصبح الجلد رماديا والشفتان زرقاوين، وقد يضيق نفس المصاب ويصاب بضعف عام.\n" +
				"2.\tاطلب العون الطبي فورا.\n" +
				"3.\tساعد المصاب على الجلوس، واسنده بوضع بطانية أو سترة وراءه ووسادة تحت ركبتيه.\n" +
				"4.\tاعطه أسبرين (تأكد من المصاب غير مصاب بالحساسية من الأسبرين)\n" +
				"5.\tطمئنه وانصحه بالراحة، وفك الملابس التي حول رقبته وصدره وخصره.\n" ,0));

		arraylist.add(new Case(R.drawable.image_10102, "ذبحة صدرية", "1.\t قد يشعر المصاب بألم في الصدر والأصابع، وقد يصبح الجلد رماديا والشفتان زرقاوين، وقد يضيق نفس المصاب ويصاب بضعف عام.\n" +
				"2.\tاطلب العون الطبي فورا.\n" +
				"3.\tساعد المصاب على الجلوس، واسنده بوضع بطانية أو سترة وراءه ووسادة تحت ركبتيه.\n" +
				"4.\tاعطه أسبرين (تأكد من المصاب غير مصاب بالحساسية من الأسبرين)\n" +
				"5.\tطمئنه وانصحه بالراحة، وفك الملابس التي حول رقبته وصدره وخصره.\n",0));
		arraylist.add(new Case(R.drawable.image_60102, "فقدان وعي", "1.\tافتح مسالك الهواء لدى المصاب برفع الفك وإمالة الرأس، اعمل على إزالة أي مادة ظاهرة تسد المجرى، فك الملابس الضيقة ، وتحقق من التنفس، وإذا لزم الأمر اعمل على انعاشه.\n" +
				"2.\tقيم مستوى الاستجابة وتحقق من سرعة التنفس والنبض.\n" +
				"3.\tضع المصاب في وضع الإفاقة.\n" +
				"4.\tغط المصاب ببطانية\n" +
				"5.\tانقله بسرعة إلى المستشفى\n" +
				"6.\tإذا تأخر النقل إلى المستشفى، استمر في التحقق من مستوى الاستجابة وسرعة التنفس والنبض كل 10 دقائق، ويجب إعطائ تقرير مكتوب إلى الطبيب أو سيارة الاسعاف.\n",0));

		arraylist.add(new Case(R.drawable.image_60101, "سكتة دماغية", "1.\tإذا كان المصاب واعيا ، أجلسه بحيث يكون الرأس والكتفان مرتفعة قليلا ومسنودة، وأدر رأسه جالسا لتسمح بتصريف اللعاب من الفم.\n" +
				"2.\tفك أي ملابس ضيقة حول العنق والصدر والخصر، لمساعدة الدورة الدموية والتنفس.\n" +
				"3.\tإذا فقد المصاب وعيه افتح مسلك الهواء لديه، وتحقق من التنفس ثم اعمل على انعاشه، وضعه في وضع الإفاقة.\n" +
				"4.\tاعمل على نقله بسرعة إلى المستشفى.\n" +
				"5.\tتحدث مع المصاب لطمأنته أثناء انتظار سيارة الإسعاف.\n",0));




		arraylist.add(new Case(R.drawable.image_50101, "صرع", "1.\tلا تكبح حركة المصاب قسراً، ولا تضع أي شيء في فمه ولا تحاول فتحه، لا تحاول إفاقة المصاب.\n" +
				"2.\tإذا أمكن فك الملابس حول رقبته ، ولا تضع شيئا تحت رأسه لأنه قد يسد مجرى التنفس لديه، وإنما ضع ما وسادة أو شيء طري حول رأسه ليحميه من الإصابة.\n" +
				"3.\tعند انتهاء النوبة، ابق مع المصاب حتى تتأكد من أن إفاقته تمت.\n" +
				"4.\tفي حال الضرورة ، اطلب الإسعاف.\n",0));

		arraylist.add(new Case(R.drawable.image_50102, "لسعة /لدغة ", "1.\tإذا بقيت إبرة الحشرة في الجلد، أمسك بملقط ما يكون إلى الجلد ثم اقبض على الإبرة وانزعها.\n" +
				"2.\tاغسل الجرح بالماء والصابون.\n" +
				"3.\tلتسكين الألم وتخفيف التورم ، ضع كمادة باردة أو كحول طبي أو بيكربونات الصودا.\n" +
				"4.\tاتصل بالإسعاف إذا بدى على المصاب علامات حساسية .\n",R.drawable.stik));



		arraylist.add(new Case(R.drawable.image_10109, "ليّ العضل", "1.\tاسند الجزء المصاب في أفضل وضع يؤمن الراحة القصوى.\n" +
				"2.\tضع كيسا من الثلج، أو رفادة مبللة بالماء البارد لمدة لا تقل عن 30 دقيقة.\n" +
				"3.\tإذا لم تتحسن الإصابة ، اطلب العون الطبي.\n",R.drawable.lay));


		arraylist.add(new Case(R.drawable.image_10104, "كسر عظام", "1.\tركَز واسند الطرف المكسور، باستخادم وسادة أو قطعة ثياب لتجنب أي حركة غير ضرورية.\n" +
				"2.\tإذا كانت المنطقة المصابة مشوهة بوضوح، أو مؤلمة بشدة، اتصل بالإسعاف.\n" +
				"3.\tتأكد من أن الإصابة مثبتة حتى تصل المساعدة.\n",R.drawable.leg));

		arraylist.add(new Case(R.drawable.image_10201, "نوبة ربو", "1.\tأشر على  المصاب بالجلوس مع ميل خفيف إلى الأمام ، وأن يتكئ على مسند كالطاولة مثلا.\n" +
				"2.\tإذا كان المصاب يحمل علاجه، فدعه يستعمله.\n" +
				"3.\tطمئن المصاب وهدئه باستمرار\n" +
				"4.\tإذا زادت نوبة الربو، أو لم يتحسن المصاب بعد أخذ الدواء، اتصل بالإسعاف.\n",0));
		arraylist.add(new Case(R.drawable.image_10103, "نزيف دم", "\n" +
				"1.\tارفع واسند العضو ، إذا كان الجرح في طرف من الأطراف.\n" +
				"2.\tاضغط مكان الجرح بأي شيء متوفر لديك، لتوقف أو تبطئ تدفق الدم\n" +
				"3.\tإذا كان النزيف حاد ، اتصل بالإسعاف.\n" +
				"4.\tلا تنزع الضماد إذا استمر النزف، بل أضف ضمادات أخرى، وابق الضغط على مكان الجرح حتى وصول سيارة الإسعاف.\n",R.drawable.bleed));

		arraylist.add(new Case(R.drawable.image_30101, "نقص سكر الدم", "1.\tإذا كان المصاب واعيا وقادراً على البلع أعطه فوراً قطعاً من السكر أو شراباً محلى.\n" +
				"2.\tطمئن المصاب.\n" +
				"3.\tمعظم المصابين يتحسنون بالتدريج، لكن إن شككت بسرعة تنفس المصاب، أو تعرقه ، أو في حال فقدانه للوعي، اتصل الإسعاف\n",0));



		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter(this, arraylist);

		// Binds the Adapter to the ListView
		list.setAdapter(adapter);

		// Locate the EditText in listview_main.xml
		editsearch = (EditText) findViewById(R.id.search);

		// Capture Text in EditText
		editsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
				adapter.filter(text);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
										  int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
									  int arg3) {
				// TODO Auto-generated method stub
			}
		});
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_emergency) {
			Intent i=new Intent(this, SearchActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}
		else
		if (id == R.id.action_hospital) {
			Intent i=new Intent(this, Location.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


}
