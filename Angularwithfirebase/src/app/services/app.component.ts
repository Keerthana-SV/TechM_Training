import { Component, ElementRef, ViewChild, AfterViewChecked, inject } from '@angular/core';
import { AuthService } from './services/auth.service';
import { ChatService } from './services/chat.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [CommonModule, FormsModule],
})
export class AppComponent implements AfterViewChecked {
  private authService = inject(AuthService);
  private chatService = inject(ChatService);

  user$ = this.authService.user$;
  messages$: Observable<any> = this.chatService.getMessages();
  messageText = '';

  @ViewChild('messagesContainer') private messagesContainer!: ElementRef;

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

  private scrollToBottom(): void {
    if (this.messagesContainer) {
      this.messagesContainer.nativeElement.scrollTop = this.messagesContainer.nativeElement.scrollHeight;
    }
  }
}
