import { Component, ElementRef, ViewChild, AfterViewChecked, inject, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { ChatService } from './services/chat.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],  // Updated for multiple styles
  imports: [CommonModule, FormsModule],
})
export class AppComponent implements OnInit, AfterViewChecked {
  private authService = inject(AuthService);
  private chatService = inject(ChatService);

  user$ = this.authService.user$;
  messages$: Observable<any> = this.chatService.getMessages();
  messageText = '';

  currentTheme = 'light-theme'; // default theme

  @ViewChild('messagesContainer') private messagesContainer!: ElementRef;

  ngOnInit() {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
      this.currentTheme = savedTheme;
      document.body.className = this.currentTheme;
    }
  }

  switchTheme(theme: string) {
    this.currentTheme = theme;
    document.body.className = theme;
    localStorage.setItem('theme', theme);
  }

  ngAfterViewChecked() {
    this.scrollToBottom();
  }

  login() {
    this.authService.loginWithGoogle();
  }

  logout() {
    this.authService.logout();
  }

  sendMessage(user: any) {
    if (this.messageText.trim()) {
      this.chatService.sendMessage(user.uid, user.displayName, this.messageText);
      this.messageText = '';
    }
  }
  isDropdownOpen = false;

toggleDropdown() {
  this.isDropdownOpen = !this.isDropdownOpen;
}


  private scrollToBottom(): void {
    if (this.messagesContainer) {
      this.messagesContainer.nativeElement.scrollTop = this.messagesContainer.nativeElement.scrollHeight;
    }
  }
}
