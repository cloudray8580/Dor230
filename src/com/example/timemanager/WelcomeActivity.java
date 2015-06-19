package com.example.timemanager;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author sony-pc
 * ������������棬��Ҫ��������Button������¼��ע��
 * ʵ��������������ת����
 */
public class WelcomeActivity extends Activity implements OnClickListener{
	
	Button button_login;
	Button button_register;
	
	private void findView() {
		// Ϊɶ���߳�����Բ���UI��
		button_login = (Button)findViewById(R.id.login);
		button_login.setVisibility(View.VISIBLE);
		button_register = (Button)findViewById(R.id.register);
		button_register.setVisibility(View.VISIBLE);
	}
	
	private void setListener() {
		button_login.setOnClickListener(this);
		button_register.setOnClickListener(this);
	}
	
	public void init() {
		findView();
		setListener();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		  Timer timer = new Timer();//timer����һ���߳�,����̲߳���ִ��task
		  
		  TimerTask task = new TimerTask() { //timertaskʵ��runnable�ӿ�,TimerTask��ʹ���һ����ָ��ʱ����ִ�е�task
			  @Override
			   public void run() {
				  runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						init();
					}
				  });
			   }
		  };
		// Schedule a task for single execution after a specified delay.
		   timer.schedule(task, 1000 * 1);//�������task���ӳ�����֮���Զ�ִ��

//		findView();
//		setListener();  
	
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.login:
			Intent intent1 = new Intent(WelcomeActivity.this, LoginActivity.class);
			startActivity(intent1);
			break;
		case R.id.register:
			Intent intent2 = new Intent(WelcomeActivity.this, RegisterActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}
}
